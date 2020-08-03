class fiscalCalendarBuilder {
    def seedDateStr = '2013/12/29' //Must be day 1 of 371 days long year.
    def startDateStr = '2021/01/01'
    def numberOfDays = 600
    def daysInSevenYearsSet = 2191
    def fileName = 'FiscalCalendar.txt'
    def debug = 0
    def months = [ "Jan", "Feb" , "Mar" , "Apr" , "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dec", "Error" ]
    def quarters = [ "1st Qtr", "2nd Qtr" ,"3rd Qtr", "4th Qtr"]

    void createFiscalCalendarFile () {

        def dateId = 0
        def relativeDateId = 0
        def relativeDayNumber = 0
        def relativeYearNumber = 0
        def absolueBlockNumber = 0
        def absoluteYearNumber = 0
        def relativeWeekNumber = 0
        def relativeMonthNumber = 0
        def relativeQuarterNumber = 0
        def dayInWeekNumber = 0
        def dayInMonthNumber = 0
        def dayInQuarterNumber = 0
        def dayInYearNumber = 0
        def weekStartDate = new Date()
        def weekEndDate = new Date()
        def weekInMonth = 0
        def weekInQuarter = 0
        def weekInYear = 0
        def monthInQuarter = 0
        def monthInYear = 0
        def holidayIndicator = ''
        def yearWorkingDayDate = new Date()
        def monthWorkDaysNumber = 0
        def quarterNum = 0
        def previousQuarterNum = 0
        def previousQuarterYearNum = 0
        def yearNum = 0
        def quarterStartDate = new Date()
        def quarterEndDate = new Date()
        def yearStartDate = new Date()
        def yearEndDate = new Date()
        def monthStartDate = new Date()
        def monthEndDate = new Date()

        def dateFormat = 'yyyy/MM/dd'
        def seedDate = new Date().parse(dateFormat, seedDateStr)
        def pivotDate = new Date().parse(dateFormat,startDateStr)

        File file = new File(fileName)
        println file.getAbsolutePath()

        file.write("DT_UID;")
        file.append("DT;")
        file.append("Fiscal_WK_SHORT_NAME;")
        file.append("Fiscal_MO_SHORT_NAME;")
        file.append("Fiscal_QUARTER_SHORT_NAME;")
        file.append("Fiscal_YR_SHORT_NAME;")
        file.append("Fiscal_DAY_IN_WK_NUM;")
        file.append("Fiscal_DAY_IN_MO_NUM;")
        file.append("Fiscal_DAY_IN_QUARTER_NUM;")
        file.append("Fiscal_DAY_IN_YR_NUM; ")
        file.append("Fiscal_WK_START_DT;")
        file.append("Fiscal_WK_END_DT;")
        file.append("Fiscal_WK_IN_MO_NUM;")
        file.append("Fiscal_WK_IN_YR_NUM;")
        file.append("Fiscal_MO_IN_QUARTER_NUM;")
        file.append("Fiscal_MON_IN_YR_NUM;")
        file.append("Fiscal_YR_NUM;")
        file.append("Holiday_IND;")
        file.append("JULIAN_DT_NUM;")
        file.append("PREV_Fiscal_YR_WKDY_DT;")
        file.append("Fiscal_MO_WORK_DAYS_NUM;")
        file.append("Fiscal_QUARTER_NUM;")
        file.append("Fiscal_PREV_QUARTER_YEAR_NUM;")
        file.append("Fiscal_QTR_START_DT;")
        file.append("Fiscal_QTR_END_DT;")
        file.append("Fiscal_YR_START_DT;")
        file.append("Fiscal_YR_END_DT;")
        file.append("Fiscal_MO_START_DT;")
        file.append("Fiscal_MO_END_DT;")

        if ( debug == 1)
            file.append("AbsoluteBlockNumber;AbsoluteYearNumber;RelativeDateID;RelativeYearNumber;relativeDayNumber;RelativeWeekNumber;")

        file.append(";\n")

        for (int i = 0; i < numberOfDays; i++ ) {
            //Calculations
            dateId = pivotDate - seedDate
            absolueBlockNumber = ( dateId / daysInSevenYearsSet).toInteger()
            relativeDateId = dateId % daysInSevenYearsSet
            absoluteYearNumber = calculateAbsoluteYearNumber(relativeDateId, absolueBlockNumber)
            yearNum = ( seedDate.format('yyyy').toInteger() + absoluteYearNumber + 1 )
            relativeDayNumber = calculateDayNumber(relativeDateId)
            relativeYearNumber = calculateRelativeYearNumber(relativeDateId)
            relativeWeekNumber = calculateRelativeWeekNumber(relativeDayNumber)
            relativeMonthNumber = calculateRelativeMonthNumber(relativeWeekNumber, relativeYearNumber)
            relativeQuarterNumber = calculateRelativeQuarterNumber(relativeWeekNumber, relativeYearNumber)
            dayInWeekNumber = calculateDayInWeekNumber(relativeDateId)
            dayInMonthNumber = calculateDayInMonthNumber(relativeDayNumber, relativeMonthNumber, relativeYearNumber)
            dayInQuarterNumber = calculateDayInQuarterNumber(relativeDayNumber, relativeQuarterNumber)
            dayInYearNumber = relativeDayNumber + 1
            weekStartDate = pivotDate.minus(dayInWeekNumber - 1)
            weekEndDate = pivotDate.plus( 7 - dayInWeekNumber )
            weekInMonth = calculateWeekInMonthNumber(relativeWeekNumber, relativeMonthNumber,relativeYearNumber)
            weekInYear = relativeWeekNumber + 1
            monthInQuarter = calculateMonthInQuarterNumber(relativeMonthNumber, relativeQuarterNumber)
            monthInYear = relativeMonthNumber + 1
            holidayIndicator = calculateHolidayIndicator(pivotDate)
            //yearWorkingDayDate = calculateYearWorkingDayDate(pivotDate)
            monthWorkDaysNumber = calculateMonthWorkDaysNumber(pivotDate, relativeMonthNumber, relativeYearNumber)
            quarterNum = relativeQuarterNumber
            previousQuarterNum = calculatePreviousQuarterNumber(relativeQuarterNumber) + 1
            previousQuarterYearNum = calculatePreviousQuarterYearNumber(relativeQuarterNumber, yearNum)
            quarterStartDate = calculateQuarterStartDate(pivotDate, dayInQuarterNumber)
            quarterEndDate = calculateQuarterEndDate(pivotDate, dayInQuarterNumber, relativeQuarterNumber, relativeYearNumber)
            yearStartDate = calculateYearStartDate(pivotDate, dayInYearNumber)
            yearEndDate = calculateYearEndDate(pivotDate, relativeYearNumber, dayInYearNumber)
            monthStartDate = calculateMonthStartDate(pivotDate, dayInMonthNumber)
            monthEndDate = calculateMonthEndDate(pivotDate, dayInMonthNumber, relativeMonthNumber, relativeYearNumber)

            //Flat file fields
            file.append(pivotDate.format(dateFormat) + ";")
            file.append(pivotDate.format(dateFormat) + ";")
            file.append( "F WK " + ( relativeWeekNumber + 1 ) + ";"  )
            file.append( "F " + months[relativeMonthNumber] + ";")
            file.append( "F " + quarters[relativeQuarterNumber] + ";")
            file.append( "F " + yearNum.toString() + ";")
            file.append(dayInWeekNumber + ";")
            file.append(dayInMonthNumber + ";")
            file.append(dayInQuarterNumber + ";")
            file.append(dayInYearNumber + ";")
            file.append(weekStartDate.format(dateFormat) + ";")
            file.append(weekEndDate.format(dateFormat) + ";")
            file.append(weekInMonth + ";")
            file.append(weekInYear + ";")
            file.append(monthInQuarter + ";")
            file.append(monthInYear + ";")
            file.append( yearNum + ";")
            file.append( holidayIndicator.toString() + ";")
            file.append( /*yearWorkingDayDate.toString() + */ ";")
            file.append( monthWorkDaysNumber + ";")
            file.append( quarterNum + ";")
            file.append( previousQuarterNum + ";")
            file.append( previousQuarterYearNum + ";")
            file.append( quarterStartDate.format(dateFormat) + ";")
            file.append( quarterEndDate.format(dateFormat) + ";")
            file.append( yearStartDate.format(dateFormat) + ";")
            file.append( yearEndDate.format(dateFormat) + ";")
            file.append( monthStartDate.format(dateFormat) + ";")
            file.append( monthEndDate.format(dateFormat) + ";")

            //Debug Fields
            if ( debug == 1 ) {
                file.append(dateId + ";")
                file.append(absolueBlockNumber + ";")
                file.append(absoluteYearNumber.toInteger() + ";")
                file.append(relativeDateId + ";")
                file.append(relativeYearNumber + ";")
                file.append(relativeDayNumber + ";")
                file.append(relativeWeekNumber + ";")
            }

            pivotDate = pivotDate.next()
            file.append("\n")
        }
    }

    private Date calculateMonthEndDate(Date pivotDate, int dayInMonthNumber, int relativeMonthNumber, int relativeYearNumber) {
        if ( relativeMonthNumber == 0 ) return pivotDate.plus(28 - dayInMonthNumber)
        if ( relativeMonthNumber == 1) return pivotDate.plus(28 - dayInMonthNumber)
        if ( relativeMonthNumber == 2) return pivotDate.plus(35 - dayInMonthNumber)
        if ( relativeMonthNumber == 3) return pivotDate.plus(28 - dayInMonthNumber)
        if ( relativeMonthNumber == 4) return pivotDate.plus(28 - dayInMonthNumber)
        if ( relativeMonthNumber == 5) return pivotDate.plus(35 - dayInMonthNumber)
        if ( relativeMonthNumber == 6) return pivotDate.plus(28 - dayInMonthNumber)
        if ( relativeMonthNumber == 7) return pivotDate.plus(28 - dayInMonthNumber)
        if ( relativeMonthNumber == 8) return pivotDate.plus(35 - dayInMonthNumber)
        if ( relativeMonthNumber == 9) return pivotDate.plus(28 - dayInMonthNumber)
        if ( relativeMonthNumber == 10 ) {
            if ( relativeYearNumber == 0 ) return pivotDate.plus(35 - dayInMonthNumber)
            else return pivotDate.plus(28 - dayInMonthNumber)
        }
        if (relativeMonthNumber == 11) return pivotDate.plus(35 - dayInMonthNumber)

        return pivotDate
    }

    private Date calculateMonthStartDate(Date pivotDate, int dayInMonthNumber) {
        return pivotDate.minus(dayInMonthNumber - 1)
    }

    private Date calculateYearEndDate(Date pivotDate, int relativeYearNumber, int dayInYearNumber) {
        if ( relativeYearNumber == 0 ) return pivotDate.plus( 371 - dayInYearNumber )
            else pivotDate.plus( 364 - dayInYearNumber )
    }

    private Date calculateYearStartDate(Date pivotDate, int dayInYearNumber) {
        return pivotDate.minus(dayInYearNumber - 1)
    }

    private Date calculateQuarterEndDate(Date pivotDate, int dayInQuarterNumber, int relativeQuarterNumber, int relativeYearNumber) {
        if ( relativeQuarterNumber == 0 ) {
            if ( relativeQuarterNumber == 0 || relativeQuarterNumber == 1 || relativeQuarterNumber == 2 )
                return pivotDate.plus( 91 - dayInQuarterNumber )
            else pivotDate.plus( 98 - dayInQuarterNumber )
        } else return pivotDate.plus( 91 - dayInQuarterNumber )


    }

    private Date calculateQuarterStartDate(Date pivotDate, int dayInQuarterNumber) {
        return pivotDate.minus(dayInQuarterNumber - 1)
    }

    private int calculatePreviousQuarterYearNumber(int relativeQuarterNumber, int yearNum) {
        if ( relativeQuarterNumber == 0 ) return yearNum - 1
        if ( relativeQuarterNumber == 1 ) return yearNum
        if ( relativeQuarterNumber == 2 ) return yearNum
        if ( relativeQuarterNumber == 3 ) return yearNum
        return 9

    }

    private int calculatePreviousQuarterNumber(int relativeQuarterNumber) {
        if ( relativeQuarterNumber == 0 ) return 3
        if ( relativeQuarterNumber == 1 ) return 0
        if ( relativeQuarterNumber == 2 ) return 1
        if ( relativeQuarterNumber == 3 ) return 2
        return 9
    }

    int calculateMonthWorkDaysNumber(Date pivotDate, int relativeMonthNumber, int relativeYearNumber) {
        if ( relativeMonthNumber == 0 ) return 20
        if ( relativeMonthNumber == 1) return 20
        if ( relativeMonthNumber == 2) return 25
        if ( relativeMonthNumber == 3) return 20
        if ( relativeMonthNumber == 4) return 20
        if ( relativeMonthNumber == 5) return 25
        if ( relativeMonthNumber == 6) return 20
        if ( relativeMonthNumber == 7) return 20
        if ( relativeMonthNumber == 8) return 25
        if ( relativeMonthNumber == 9) return 20
        if ( relativeMonthNumber == 10 ) {
           if ( relativeYearNumber == 0 ) return 25
           else return 20
        }
        if (relativeMonthNumber == 11) return 25
        return 0
    }

    private Date calculateYearWorkingDayDate(Date pivotDate) {
        return pivotDate
    }

    private char calculateHolidayIndicator(Date pivotDate) {
        return 'N' as char
    }

    int calculateAbsoluteYearNumber( int relativeDateId, int absoluteBlockNumber ) {
        def relativeYearNumber = calculateRelativeYearNumber(relativeDateId)

        return 1 * absoluteBlockNumber + relativeYearNumber + absoluteBlockNumber * 5
    }

    int calculateRelativeYearNumber(int relativeDateId) {
        if ( relativeDateId < 371) return 0
        else return ( ( (relativeDateId - 371 ) / 364 ) + 1 )
    }

    int calculateDayNumber ( int relativeDateId ) {
        if ( relativeDateId < 371) return relativeDateId
        else return  ( (relativeDateId - 371 ) % 364 )
    }

    int calculateRelativeWeekNumber(int relativeDateId) {
        return relativeDateId / 7
    }
    int calculateDayInWeekNumber(int relativeDateId) {
        return relativeDateId % 7 + 1
    }

    int calculateRelativeMonthNumber(int relativeWeekNumber, int relativeYearNum) {
        if ( relativeWeekNumber == 0 || relativeWeekNumber == 1 || relativeWeekNumber == 2 || relativeWeekNumber == 3 ) return 0
        if ( relativeWeekNumber == 4 || relativeWeekNumber == 5 || relativeWeekNumber == 6 || relativeWeekNumber == 7 ) return 1
        if ( relativeWeekNumber == 8 || relativeWeekNumber == 9 || relativeWeekNumber == 10 || relativeWeekNumber == 11 ||
                relativeWeekNumber == 12 ) return 2
        if  ( relativeWeekNumber == 13 || relativeWeekNumber == 14 || relativeWeekNumber == 15 || relativeWeekNumber == 16 ) return 3
        if ( relativeWeekNumber == 17 || relativeWeekNumber == 18 || relativeWeekNumber == 19 || relativeWeekNumber == 20 ) return 4
        if ( relativeWeekNumber == 21 || relativeWeekNumber == 22 || relativeWeekNumber == 23 || relativeWeekNumber == 24 ||
                relativeWeekNumber == 25 ) return 5
        if ( relativeWeekNumber == 26 || relativeWeekNumber == 27 || relativeWeekNumber == 28 || relativeWeekNumber == 29 ) return 6
        if ( relativeWeekNumber == 30 || relativeWeekNumber == 31 || relativeWeekNumber == 32 || relativeWeekNumber == 33 ) return 7
        if (relativeWeekNumber == 34 || relativeWeekNumber == 35 || relativeWeekNumber == 36 || relativeWeekNumber == 37 ||
                relativeWeekNumber == 38 ) return 8
        if ( relativeYearNum == 0) {
            if ( relativeWeekNumber == 39 || relativeWeekNumber == 40 || relativeWeekNumber == 41 || relativeWeekNumber == 42 ) return 9
            if ( relativeWeekNumber == 43 || relativeWeekNumber == 44 || relativeWeekNumber == 45 || relativeWeekNumber == 46 ||
                    relativeWeekNumber == 47) return 10
            if (relativeWeekNumber == 48 || relativeWeekNumber == 49 || relativeWeekNumber == 50 || relativeWeekNumber == 51 ||
                    relativeWeekNumber == 52 ) return 11
        } else {
            if ( relativeWeekNumber == 39 || relativeWeekNumber == 40 || relativeWeekNumber == 41 || relativeWeekNumber == 42 ) return 9
            if ( relativeWeekNumber == 43 || relativeWeekNumber == 44 || relativeWeekNumber == 45 || relativeWeekNumber == 46 ) return 10
            if (relativeWeekNumber == 47 || relativeWeekNumber == 48 || relativeWeekNumber == 49 || relativeWeekNumber == 50 ||
                    relativeWeekNumber == 51 ) return 11
        }
        return 12
    }

    int calculateRelativeQuarterNumber(int relativeWeekNumber, int relativeYearNum) {
        if  ( relativeWeekNumber == 0 || relativeWeekNumber == 1 || relativeWeekNumber == 2 || relativeWeekNumber == 3 ) return 0
        if ( relativeWeekNumber == 4 || relativeWeekNumber == 5 || relativeWeekNumber == 6 || relativeWeekNumber == 7 ) return 0
        if ( relativeWeekNumber == 8 || relativeWeekNumber == 9 || relativeWeekNumber == 10 || relativeWeekNumber == 11 ||
                relativeWeekNumber == 12 ) return 0
        if  ( relativeWeekNumber == 13 || relativeWeekNumber == 14 || relativeWeekNumber == 15 || relativeWeekNumber == 16 ) return 1
        if ( relativeWeekNumber == 17 || relativeWeekNumber == 18 || relativeWeekNumber == 19 || relativeWeekNumber == 20 ) return 1
        if ( relativeWeekNumber == 21 || relativeWeekNumber == 22 || relativeWeekNumber == 23 || relativeWeekNumber == 24 ||
                relativeWeekNumber == 25 ) return 1
        if ( relativeWeekNumber == 26 || relativeWeekNumber == 27 || relativeWeekNumber == 28 || relativeWeekNumber == 29 ) return 2
        if ( relativeWeekNumber == 30 || relativeWeekNumber == 31 || relativeWeekNumber == 32 || relativeWeekNumber == 33 ) return 2
        if (relativeWeekNumber == 34 || relativeWeekNumber == 35 || relativeWeekNumber == 36 || relativeWeekNumber == 37 ||
                relativeWeekNumber == 38 ) return 2
        if ( relativeYearNum == 0) {
            if ( relativeWeekNumber == 39 || relativeWeekNumber == 40 || relativeWeekNumber == 41 || relativeWeekNumber == 42 ) return 3
            if ( relativeWeekNumber == 43 || relativeWeekNumber == 44 || relativeWeekNumber == 45 || relativeWeekNumber == 46 ||
                    relativeWeekNumber == 47) return 3
            if (relativeWeekNumber == 48 || relativeWeekNumber == 49 || relativeWeekNumber == 50 || relativeWeekNumber == 51 ||
                    relativeWeekNumber == 52 ) return 3
        } else {
            if ( relativeWeekNumber == 39 || relativeWeekNumber == 40 || relativeWeekNumber == 41 || relativeWeekNumber == 42 ) return 3
            if ( relativeWeekNumber == 43 || relativeWeekNumber == 44 || relativeWeekNumber == 45 || relativeWeekNumber == 46 ) return 3
            if (relativeWeekNumber == 47 || relativeWeekNumber == 48 || relativeWeekNumber == 49 || relativeWeekNumber == 50 ||
                    relativeWeekNumber == 51 ) return 3
        }
        return 4
    }

    int calculateDayInMonthNumber (int relativeDayNumber, int relativeMonthNumber, int relativeYearNumber) {
        if ( relativeMonthNumber == 0 ) return relativeDayNumber + 1
        if ( relativeMonthNumber == 1) return relativeDayNumber - 28 + 1
        if ( relativeMonthNumber == 2) return relativeDayNumber - 56 + 1
        if ( relativeMonthNumber == 3) return relativeDayNumber - 91 + 1
        if ( relativeMonthNumber == 4) return relativeDayNumber - 119 + 1
        if ( relativeMonthNumber == 5) return relativeDayNumber - 147 + 1
        if ( relativeMonthNumber == 6) return relativeDayNumber - 182 + 1
        if ( relativeMonthNumber == 7) return relativeDayNumber - 210 + 1
        if ( relativeMonthNumber == 8) return relativeDayNumber - 238 + 1
        if ( relativeMonthNumber == 9) return relativeDayNumber - 273 + 1
        if (relativeMonthNumber == 10) return relativeDayNumber - 301 + 1
        if ( relativeYearNumber == 0) {
            if ( relativeMonthNumber == 11) return relativeDayNumber - 336 + 1
        } else {
            if ( relativeMonthNumber == 11) return relativeDayNumber - 329 + 1
        }
        return 0
    }

    int calculateDayInQuarterNumber (int relativeDayNumber, int relativeQuarterNumber) {
        if ( relativeQuarterNumber == 0 ) return relativeDayNumber + 1
        if ( relativeQuarterNumber == 1 ) return relativeDayNumber - 91 + 1
        if ( relativeQuarterNumber == 2 ) return relativeDayNumber - 182 + 1
        if ( relativeQuarterNumber == 3 ) return relativeDayNumber - 273 + 1
        return 0
    }

    int calculateMonthInQuarterNumber (int relativeMonthNumber, int relativeQuarterNumber) {
        if ( relativeQuarterNumber == 0 ) return relativeMonthNumber + 1
        if ( relativeQuarterNumber == 1 ) return relativeMonthNumber - 3 + 1
        if ( relativeQuarterNumber == 2 ) return relativeMonthNumber - 6 + 1
        if ( relativeQuarterNumber == 3 ) return relativeMonthNumber - 9 + 1
        return 0
    }

    int calculateWeekInMonthNumber (int relativeWeekNumber, int relativeMonthNumber, int relativeYearNumber) {
        if ( relativeMonthNumber == 0 ) return relativeWeekNumber + 1
        if ( relativeMonthNumber == 1) return relativeWeekNumber - 4 + 1
        if ( relativeMonthNumber == 2) return relativeWeekNumber - 8 + 1
        if ( relativeMonthNumber == 3) return relativeWeekNumber - 13 + 1
        if ( relativeMonthNumber == 4) return relativeWeekNumber - 17+ 1
        if ( relativeMonthNumber == 5) return relativeWeekNumber - 21 + 1
        if ( relativeMonthNumber == 6) return relativeWeekNumber - 26 + 1
        if ( relativeMonthNumber == 7) return relativeWeekNumber - 30 + 1
        if ( relativeMonthNumber == 8) return relativeWeekNumber - 34 + 1
        if ( relativeMonthNumber == 9) return relativeWeekNumber - 39 + 1
        if (relativeMonthNumber == 10) return relativeWeekNumber - 43 + 1
        if ( relativeYearNumber == 0) {
            if (relativeMonthNumber == 11) return relativeWeekNumber - 48 + 1
        } else {
            if ( relativeMonthNumber == 11) return relativeWeekNumber - 47 + 1
        }
    }

}
