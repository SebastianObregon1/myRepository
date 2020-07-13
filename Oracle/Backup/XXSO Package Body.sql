--------------------------------------------------------
--  File created - Wednesday-July-24-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package Body XXSO
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "SOBREGON"."XXSO" AS
--------------------------------------------------------
--  DDL for Procedure CLEARMIGRATIONTABLES
--------------------------------------------------------

    PROCEDURE xxso_m_clear_migration_tables AS
    BEGIN
        DELETE FROM xxso_m_migrationprocesserrors;

        DELETE FROM xxso_m_outp2lpmcompcharact;

        DELETE FROM xxso_m_outp2lpmotherprodchar;

        DELETE FROM xxso_m_outnegotiatedplstaging;

        DELETE FROM xxso_m_outproductreference;

        DELETE FROM xxso_m_outitemreference;

        DELETE FROM xxso_m_outcustomerreference;

        DELETE FROM xxso_m_outnationalaccountref;

        DELETE FROM xxso_m_outnegotiatedpabstaging;

        DELETE FROM xxso_m_outtransferprice;

    END xxso_m_clear_migration_tables;

    PROCEDURE xxso_m_perform_manual_fixes AS
    BEGIN
        DELETE FROM xxso_m_lpmxref
        WHERE
            xxso_m_lpmxref.legacy_account_number = '220120'
            AND xxso_m_lpmxref.r12_cust_acct_number = '212446';

        DELETE FROM xxso_m_lpmxref
        WHERE
            xxso_m_lpmxref.legacy_account_number = '338700'
            AND xxso_m_lpmxref.r12_cust_acct_number = '212466';

        DELETE FROM xxso_m_lpmxref
        WHERE
            xxso_m_lpmxref.legacy_account_number = '794690'
            AND xxso_m_lpmxref.r12_cust_acct_number = '212370';

        DELETE FROM xxso_m_lpmxref
        WHERE
            xxso_m_lpmxref.legacy_account_number = '90540'
            AND xxso_m_lpmxref.r12_cust_acct_number = '212555';

        DELETE FROM xxso_m_lpmxref
        WHERE
            xxso_m_lpmxref.legacy_account_number = '97840'
            AND xxso_m_lpmxref.r12_cust_acct_number = '247680';

        DELETE FROM xxso_m_lpmotherprodcharact_src
        WHERE
            xxso_m_lpmotherprodcharact_src.product_id = 'CHScLS.COMMON15931'
            AND xxso_m_lpmotherprodcharact_src.pricingfamily = 'SPECIALTY';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'CHScLS.COMMON15931'
            AND xxso_m_lpmcomponentcharact_src.pricingfamily = 'SPECIALTY';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX14162';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX76656';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX79449';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX16120';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX76684';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX53355';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX79453';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX53112';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX78870';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX77920';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX78385';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX53243';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX79648';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX78891';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX75616';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX72828';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX53352';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX78806';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX75822';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'MFG.MEXMFG.MEX79659';

        DELETE FROM xxso_m_lpmcomponentcharact_src
        WHERE
            xxso_m_lpmcomponentcharact_src.product_id = 'CLSCLS.COMMON96546'
            AND xxso_m_lpmcomponentcharact_src.itemnumber = '543230160';

        DELETE FROM xxso_m_lpmotherprodcharact_src
        WHERE
            xxso_m_lpmotherprodcharact_src.product_id = 'CLSCLS.COMMON96546'
            AND xxso_m_lpmotherprodcharact_src.itemnumber = '543230160';

    END;

    PROCEDURE xxso_r_populateebsitems AS
    BEGIN
        BEGIN
            DELETE FROM xxso_r_ebsitems;

            DELETE FROM xxso_r_pfxquotes;

            INSERT INTO xxso_r_ebsitems
                SELECT DISTINCT
                    mp.organization_code               io,
                    msib.segment1                      spec,
                    msib.description                   description,
                    msib.inventory_item_status_code    status,
                    msib.primary_uom_code              uom,
                    msib.item_type                     type,
                    CASE
                        WHEN msib.customer_order_enabled_flag = 'Y'
                             AND msib.internal_order_enabled_flag = 'Y' THEN
                            'Y'
                        WHEN msib.customer_order_enabled_flag = 'Y'
                             AND msib.internal_order_enabled_flag = 'N' THEN
                            'YN'
                        WHEN msib.customer_order_enabled_flag = 'N'
                             AND msib.internal_order_enabled_flag = 'N' THEN
                            'N'
                        WHEN msib.customer_order_enabled_flag = 'N'
                             AND msib.internal_order_enabled_flag = 'Y' THEN
                            'NY'
                        ELSE
                            'Unknown'
                    END orderable,
                    msib.customer_order_flag           order_flag,
                    msib.customer_order_enabled_flag   enabled_flag,
                    msib.creation_date                 creation_date,
                    msib.last_update_date              last_update_date
                FROM
                    inv.mtl_system_items_b@xxso_erpuat   msib
                    LEFT OUTER JOIN apps.mtl_parameters@xxso_erpuat      mp ON(msib.organization_id = mp.organization_id)
                WHERE
                    1 = 1
                    AND msib.item_catalog_group_id IS NOT NULL
                    AND mp.organization_code = 'MST'
                    AND msib.organization_id = 102;

        END;
    END;

    PROCEDURE xxso_r_populateebsquotes AS
    BEGIN
        DECLARE
            today DATE;
        BEGIN
            SELECT
                SYSDATE
            INTO today
            FROM
                dual;

            DELETE FROM xxso_r_ebsquotes;

            INSERT INTO xxso_r_ebsquotes
                SELECT
                    bl.attribute1                quote_id,
                    acct.account_number          acct_numb,
                    bh.attribute3                quote_type,
                    bh.attribute4                quote_status,
                    bh.attribute1                proj_num,
                    bh.attribute2                proj_name,
                    bh.sales_document_name,
                    bh.flow_status_code,
                    bl.line_number               linenumber,
                    bl.ordered_item              item,
                    pl.operand                   price,
                    bl.order_quantity_uom        uom,
                    le.start_date_active,
                    le.end_date_active,
                    bl.creation_date,
                    bl.last_update_date,
                    bl.freight_terms_code        freightterms,
                    bl.attribute2                applyquantitybreak,
                    bl.attribute4                sheetingwaive,
                    bl.attribute6                waiveminfreight,
                    bl.attribute7                trimwaive,
                    bl.attribute8                trimmax,
                    bl.attribute9                quotecomment,
                    bl.attribute10               shortrollwaive,
                    bh.transactional_curr_code   currency
                FROM
                    apps.oe_blanket_headers_all@xxso_erp   bh
                    LEFT OUTER JOIN apps.oe_blanket_lines_all@xxso_erp     bl ON(bh.header_id = bl.header_id)
                    LEFT OUTER JOIN apps.oe_blanket_lines_ext@xxso_erp     le ON(le.line_id = bl.line_id)
                    LEFT OUTER JOIN apps.qp_list_lines_v@xxso_erp          pl ON(pl.list_header_id = bl.price_list_id
                                                                        AND le.qp_list_line_id = pl.list_line_id)
                    LEFT OUTER JOIN ar.hz_cust_accounts@xxso_erp           acct ON(acct.cust_account_id = bh.sold_to_org_id)
                WHERE
                    1 = 1
                    AND le.end_date_active >= trunc(SYSDATE)+ 1
                ORDER BY
                    bl.creation_date DESC;

            DELETE FROM xxso_r_ebsinterface;

            INSERT INTO xxso_r_ebsinterface
                SELECT
                    quote_id,
                    status,
                    message,
                    item_name,
                    customer_number
                FROM
                    apps.xxmg_qtci080_price_updates_stg@xxso_erp
                WHERE
                    end_date >= trunc(SYSDATE)
                    --AND(status = 'ERROR' OR status = 'DUPLICATE')
                    ;

        END;
    END;

    PROCEDURE xxso_r_populateebsquotes_uat AS
    BEGIN
        DECLARE
            today DATE;
        BEGIN
            SELECT
                SYSDATE
            INTO today
            FROM
                dual;

            DELETE FROM xxso_r_ebsquotes;

            INSERT INTO xxso_r_ebsquotes
                SELECT
                    bl.attribute1                quote_id,
                    acct.account_number          acct_numb,
                    bh.attribute3                quote_type,
                    bh.attribute4                quote_status,
                    bh.attribute1                proj_num,
                    bh.attribute2                proj_name,
                    bh.sales_document_name,
                    bh.flow_status_code,
                    bl.line_number               linenumber,
                    bl.ordered_item              item,
                    pl.operand                   price,
                    bl.order_quantity_uom        uom,
                    le.start_date_active,
                    le.end_date_active,
                    bl.creation_date,
                    bl.last_update_date,
                    bl.freight_terms_code        freightterms,
                    bl.attribute2                applyquantitybreak,
                    bl.attribute4                sheetingwaive,
                    bl.attribute6                waiveminfreight,
                    bl.attribute7                trimwaive,
                    bl.attribute8                trimmax,
                    bl.attribute9                quotecomment,
                    bl.attribute10               shortrollwaive,
                    bh.transactional_curr_code   currency
                FROM
                    apps.oe_blanket_headers_all@xxso_erpuat   bh
                    LEFT OUTER JOIN apps.oe_blanket_lines_all@xxso_erpuat     bl ON(bh.header_id = bl.header_id)
                    LEFT OUTER JOIN apps.oe_blanket_lines_ext@xxso_erpuat     le ON(le.line_id = bl.line_id)
                    LEFT OUTER JOIN apps.qp_list_lines_v@xxso_erpuat          pl ON(pl.list_header_id = bl.price_list_id
                                                                           AND le.qp_list_line_id = pl.list_line_id)
                    LEFT OUTER JOIN ar.hz_cust_accounts@xxso_erpuat           acct ON(acct.cust_account_id = bh.sold_to_org_id)
                WHERE
                    1 = 1
                    AND le.end_date_active >= trunc(SYSDATE)+ 1
                ORDER BY
                    bl.creation_date DESC;

            DELETE FROM xxso_r_ebsinterface;

            INSERT INTO xxso_r_ebsinterface
                SELECT
                    quote_id,
                    status,
                    message,
                    item_name,
                    customer_number
                FROM
                    apps.xxmg_qtci080_price_updates_stg@xxso_erpuat
                WHERE
                    end_date >= trunc(SYSDATE)
                    --AND(status = 'ERROR' OR status = 'DUPLICATE')
                    ;

        END;
    END;

    PROCEDURE xxso_m_mock_build AS
    BEGIN
        dbms_output.put_line(TO_CHAR(systimestamp)
                             || ' - MOCK Process Start');
        
        -- Clear Migration errors and Output Tables
        dbms_output.put_line(TO_CHAR(systimestamp)
                             || ' - Clearing Migration tables');
        xxso.xxso_m_clear_migration_tables; 
        
        -- Populate EBS Items
        dbms_output.put_line(TO_CHAR(systimestamp)
                             || ' - Pulling EBS Itmes');
        xxso.xxso_m_populateebsitems;
        
        -- Perform Manual Fixes
        dbms_output.put_line(TO_CHAR(systimestamp)
                             || ' - Performing Manual Fixes');
        xxso.xxso_m_perform_manual_fixes;
        
        -- Check Errors
        dbms_output.put_line(TO_CHAR(systimestamp)
                             || ' - Checking Errors');
        xxso.xxso_m_check_pre_errors;
        
        -- Populate LPM Component Characteristics
        dbms_output.put_line(TO_CHAR(systimestamp)
                             || ' - Populating LPM Component Characteristics');
        xxso.xxso_m_popoutp2lpmcompchar;
        
        -- Populate LPM Other Characteristics
        dbms_output.put_line(TO_CHAR(systimestamp)
                             || ' - Populating LPM Other');
        xxso.xxso_m_popoutp2lpmother;
        
        -- Populate Reference files
        dbms_output.put_line(TO_CHAR(systimestamp)
                             || ' - Populating Reference Files');
        xxso.xxso_m_pop_out_reference;
        
        -- Populate Negotiated Prices
        dbms_output.put_line(TO_CHAR(systimestamp)
                             || ' - Populating Output Negotiated Prices');
        xxso.xxso_m_pop_out_negotiated;
        
        -- Populate PAB Prices
        dbms_output.put_line(TO_CHAR(systimestamp)
                             || ' - Populating Output PAB Prices');
        xxso.xxso_m_pop_out_pab;

        -- Populate Transfer Prices
        dbms_output.put_line(TO_CHAR(systimestamp)
                             || ' - Populating Transfer Prices');
        xxso.xxso_m_pop_out_transferprices;

        -- Process Error Validation
        dbms_output.put_line(TO_CHAR(systimestamp)
                             || ' - Checking POST Errors');
        xxso_m_check_post_errors;
        COMMIT;
        xxso.xxso_m_print_counts;
        dbms_output.put_line(TO_CHAR(systimestamp)
                             || ' - MOCK Process End');
    END;

    PROCEDURE xxso_m_populatepfxitems AS
        l_http_request    utl_http.req;
        l_http_response   utl_http.resp;
        l_body            VARCHAR(512);
    BEGIN
        utl_http.set_transfer_timeout(60);
        l_body := '{ "operationType": "fetch", 	"startRow": 0,	"endRow": 3,	"textMatchStyle": "exact",	"oldValues": null }';

    --utl_http.set_wallet('file:c:\wallet\pfxwallet2','SO123456');

    --l_http_request := utl_http.begin_request(url => 'https://ad.pricefx.eu/pricefx/ad-na-qa2/fetch/C',method => 'GET',http_version => 'HTTP/1.1');
        l_http_request := utl_http.begin_request('https://ad.pricefx.eu/pricefx/ad-na-qa2/fetch/P/');
    --l_http_request := utl_http.begin_request('https://gb.redhat.com/');
        utl_http.set_header(l_http_request,'Authorization','BASIC YWQtbmEtcWEyL3NlYmFzdGlhbi5vYnJlZ29uMUBhdmVyeWRlbm5pc29uLmNvbS5zaXQ6b2JyZWdvbjE='
        );
        utl_http.write_text(l_http_request,'');
        l_http_response := utl_http.get_response(l_http_request);
    END;

    PROCEDURE xxso_m_check_pre_errors AS

        n_speccount       NUMBER := 0;
        n_recordcount     NUMBER := 0;
        n_execute         NUMBER := 1;
        n_customercount   NUMBER := 0;
    BEGIN
        --Validate if all customers defined on the xref exists 
        BEGIN
            n_customercount := 0;
            SELECT
                COUNT(*)
            INTO n_customercount
            FROM
                xxso_m_lpmxref
                LEFT OUTER JOIN xxso_m_pfxcustomermaster ON xxso_m_pfxcustomermaster.customer_num_cd = xxso_m_lpmxref.r12_cust_acct_number
            WHERE
                xxso_m_pfxcustomermaster.customer_num_cd IS NULL;

            IF n_customercount <> 0 THEN
                INSERT INTO xxso_m_migrationprocesserrors VALUES(
                    '0001',
                    '',
                    '0001 - ERROR: '
                    || TO_CHAR(n_customercount)
                    || ' Missing customers from xReference on PFX Target Customer Master'
                );

                INSERT INTO xxso_m_migrationprocesserrors
                    SELECT
                        '0001',
                        xxso_m_lpmxref.r12_cust_acct_number,
                        'ERROR: '
                        || xxso_m_lpmxref.r12_cust_acct_number
                        || ' is missing from xReference on PFX Target Customer Master.'
                    FROM
                        xxso_m_lpmxref
                        LEFT OUTER JOIN xxso_m_pfxcustomermaster ON xxso_m_pfxcustomermaster.customer_num_cd = xxso_m_lpmxref.r12_cust_acct_number
                    WHERE
                        xxso_m_pfxcustomermaster.customer_num_cd IS NULL;

            END IF;

        END; --Validate if all customers defined on the xref exists 

        -- Validate no repeated records on P1LPMOtherProductCharacteristics  

        BEGIN
            n_speccount := 0;
            SELECT
                COUNT(DISTINCT specnumber)
            INTO n_speccount
            FROM
                xxso_m_lpmotherprodcharact_src
            WHERE
                specnumber IN(
                    SELECT
                        specnumber
                    FROM
                        xxso_m_lpmotherprodcharact_src
                    GROUP BY
                        specnumber
                    HAVING
                        COUNT(specnumber)> 1
                );

            IF n_speccount <> 0 THEN
                INSERT INTO xxso_m_migrationprocesserrors VALUES(
                    '0004',
                    '',
                    '0004 - ERROR: More than one record by spec on Prod1 LPM OtherProductCharacteristics PX'
                );

                INSERT INTO xxso_m_migrationprocesserrors
                    SELECT
                        '0004',
                        TO_CHAR(specnumber),
                        'Spec Number '
                        || TO_CHAR(specnumber)
                        || ' appears '
                        || TO_CHAR(COUNT(specnumber))
                        || ' times on Prod1 LPMOtherProductCharacteristics PX.'
                    FROM
                        xxso_m_lpmotherprodcharact_src
                    GROUP BY
                        '0004',
                        TO_CHAR(specnumber)
                    HAVING
                        COUNT(specnumber)> 1;

                n_execute := 0;
            END IF;

        END; -- Validate no repeated records on P1LPMOtherProductCharacteristics  

        -- 0005 - Vaidate no repeated records on P2LPMComponentCharacteristics 

        BEGIN
            n_speccount := 0;
            SELECT
                COUNT(DISTINCT product_id)
            INTO n_speccount
            FROM
                xxso_m_lpmotherprodcharact
            WHERE
                product_id IN(
                    SELECT
                        product_id
                    FROM
                        xxso_m_lpmotherprodcharact
                    GROUP BY
                        product_id
                    HAVING
                        COUNT(product_id)> 1
                );

            IF n_speccount <> 0 THEN
                INSERT INTO xxso_m_migrationprocesserrors VALUES(
                    '0005',
                    '',
                    '0005 - ERROR: More than one record by spec on Target LPMComponentCharacteristics PX'
                );

                INSERT INTO xxso_m_migrationprocesserrors
                    SELECT
                        '0005',
                        TO_CHAR(product_id),
                        'Sku '
                        || TO_CHAR(product_id)
                        || ' appears '
                        || TO_CHAR(COUNT(product_id))
                        || ' times on Target LPMComponentCharacteristics PX.'
                    FROM
                        xxso_m_lpmotherprodcharact
                    GROUP BY
                        '0005',
                        TO_CHAR(product_id)
                    HAVING
                        COUNT(product_id)> 1;

            END IF;

        END; -- 0005 - Vaidate no repeated records on P2LPMComponentCharacteristics 

        -- Validate Missing records FROM CLSUSAVariant on National Account Ref

        BEGIN
            n_recordcount := 0;
            SELECT
                COUNT(*)
            INTO n_recordcount
            FROM
                xxso_m_clsusavariant
                LEFT OUTER JOIN xxso_m_lpmxrefnationalaccount ON xxso_m_lpmxrefnationalaccount.legacy_pricing_group_number = xxso_m_clsusavariant
                .national_account
            WHERE
                xxso_m_lpmxrefnationalaccount.legacy_pricing_group_number IS NULL;

            IF n_recordcount <> 0 THEN
                INSERT INTO xxso_m_migrationprocesserrors VALUES(
                    '0006',
                    '',
                    '0006 - ERROR: '
                    || TO_CHAR(n_recordcount)
                    || ' Missing records FROM CLSUSAVariant on National Account Ref'
                );

                INSERT INTO xxso_m_migrationprocesserrors
                    SELECT DISTINCT
                        '0006',
                        TO_CHAR(xxso_m_clsusavariant.national_account),
                        'Missing CLSUSAVariant Legacy National Account '
                        || TO_CHAR(xxso_m_clsusavariant.national_account)
                        || ' on xRef.'
                    FROM
                        xxso_m_clsusavariant
                        LEFT OUTER JOIN xxso_m_lpmxrefnationalaccount ON xxso_m_lpmxrefnationalaccount.legacy_pricing_group_number
                        = xxso_m_clsusavariant.national_account
                    WHERE
                        xxso_m_lpmxrefnationalaccount.legacy_pricing_group_number IS NULL;

            END IF;

        END; -- Validate Missing records FROM CLSUSAVariant on National Account Ref

        -- Missing records FROM CLSCANVariant on National Account xRef

        BEGIN
            n_recordcount := 0;
            SELECT
                COUNT(*)
            INTO n_recordcount
            FROM
                xxso_m_clscanvariant
                LEFT OUTER JOIN xxso_m_lpmxrefnationalaccount ON xxso_m_lpmxrefnationalaccount.legacy_pricing_group_number = xxso_m_clscanvariant
                .national_account
            WHERE
                xxso_m_lpmxrefnationalaccount.legacy_pricing_group_number IS NULL;

            IF n_recordcount <> 0 THEN
                INSERT INTO xxso_m_migrationprocesserrors VALUES(
                    '0007',
                    '',
                    '0007 - ERROR: '
                    || TO_CHAR(n_recordcount)
                    || ' Missing records FROM CLSCANVariant on National Account xRef'
                );

                INSERT INTO xxso_m_migrationprocesserrors
                    SELECT DISTINCT
                        '0007',
                        TO_CHAR(xxso_m_clscanvariant.national_account),
                        'Missing CLSCANVariant Legacy National Account '
                        || TO_CHAR(xxso_m_clscanvariant.national_account)
                        || ' on xRef.'
                    FROM
                        xxso_m_clscanvariant
                        LEFT OUTER JOIN xxso_m_lpmxrefnationalaccount ON xxso_m_lpmxrefnationalaccount.legacy_pricing_group_number
                        = xxso_m_clscanvariant.national_account
                    WHERE
                        xxso_m_lpmxrefnationalaccount.legacy_pricing_group_number IS NULL;

            END IF;

        END; -- Missing records FROM CLSCANVariant on National Account xRef

        -- Missing records on Customer xRef USA

        BEGIN
            n_recordcount := 0;
            SELECT
                COUNT(*)
            INTO n_recordcount
            FROM
                xxso_m_clsusavariant
                LEFT OUTER JOIN xxso_m_lpmxref ON xxso_m_lpmxref.legacy_account_number = TO_CHAR(xxso_m_clsusavariant.customer_number
                )
            WHERE
                xxso_m_lpmxref.legacy_account_number IS NULL;

            IF n_recordcount <> 0 THEN
                INSERT INTO xxso_m_migrationprocesserrors VALUES(
                    '0008',
                    '',
                    '0008 - ERROR: '
                    || TO_CHAR(n_recordcount)
                    || 'Missing records on Customer xRef'
                );

                INSERT INTO xxso_m_migrationprocesserrors
                    SELECT DISTINCT
                        '0008',
                        TO_CHAR(xxso_m_clsusavariant.customer_number),
                        'Missing CLSUSAVariant Customer '
                        || TO_CHAR(xxso_m_clsusavariant.customer_number)
                        || ' on xRef.'
                    FROM
                        xxso_m_clsusavariant
                        LEFT OUTER JOIN xxso_m_lpmxref ON xxso_m_lpmxref.legacy_account_number = TO_CHAR(xxso_m_clsusavariant.customer_number
                        )
                    WHERE
                        xxso_m_lpmxref.legacy_account_number IS NULL;

            END IF;

        END; --Missing records on Customer xRef 

        -- Missing records on Customer xRef CAN

        BEGIN
            n_recordcount := 0;
            SELECT
                COUNT(*)
            INTO n_recordcount
            FROM
                xxso_m_clscanvariant left
                JOIN xxso_m_lpmxref ON xxso_m_lpmxref.legacy_account_number = TO_CHAR(xxso_m_clscanvariant.customer_number)
            WHERE
                xxso_m_lpmxref.legacy_account_number IS NULL;

            IF n_recordcount <> 0 THEN
                INSERT INTO xxso_m_migrationprocesserrors VALUES(
                    '0009',
                    '',
                    '0009 - ERROR: '
                    || TO_CHAR(n_recordcount)
                    || 'Missing records on Customer xRef'
                );

                INSERT INTO xxso_m_migrationprocesserrors
                    SELECT DISTINCT
                        '0009',
                        TO_CHAR(xxso_m_clscanvariant.customer_number),
                        'Missing CLSCANVariant Customer '
                        || TO_CHAR(xxso_m_clscanvariant.customer_number)
                        || ' on xRef.'
                    FROM
                        xxso_m_clscanvariant left
                        JOIN xxso_m_lpmxref ON xxso_m_lpmxref.legacy_account_number = xxso_m_clscanvariant.customer_number
                    WHERE
                        xxso_m_lpmxref.legacy_account_number IS NULL;

            END IF;

        END; -- Missing records on Customer xRef CAN

        -- Missing Customers from CLSUSAVarian on Price FX Target Customer Master

        BEGIN
            n_recordcount := 0;
            SELECT
                COUNT(*)
            INTO n_recordcount
            FROM
                xxso_m_clsusavariant left
                JOIN xxso_m_lpmxref ON xxso_m_lpmxref.legacy_account_number = TO_CHAR(xxso_m_clsusavariant.customer_number)
                LEFT OUTER JOIN xxso_m_pfxcustomermaster ON 'LPM-' || xxso_m_lpmxref.r12_cust_acct_number = xxso_m_pfxcustomermaster
                .customer_id
            WHERE
                xxso_m_pfxcustomermaster.customer_id IS NULL;

            IF n_recordcount <> 0 THEN
                INSERT INTO xxso_m_migrationprocesserrors VALUES(
                    '0010',
                    '',
                    '0010 - ERROR: '
                    || TO_CHAR(n_recordcount)
                    || 'Missing Customers from CLSUSAVatian on Price FX Target Customer Master'
                );

                INSERT INTO xxso_m_migrationprocesserrors
                    SELECT DISTINCT
                        '0010',
                        xxso_m_lpmxref.r12_cust_acct_number,
                        'Missing Customer '
                        || xxso_m_lpmxref.r12_cust_acct_number
                        || ' from CLSUSAVariant on Price FX Target Customer Master.'
                    FROM
                        xxso_m_clsusavariant
                        LEFT OUTER JOIN xxso_m_lpmxref ON xxso_m_lpmxref.legacy_account_number = TO_CHAR(xxso_m_clsusavariant.customer_number
                        )
                        LEFT OUTER JOIN xxso_m_pfxcustomermaster ON 'LPM-' || xxso_m_lpmxref.r12_cust_acct_number = xxso_m_pfxcustomermaster
                        .customer_id
                    WHERE
                        xxso_m_pfxcustomermaster.customer_id IS NULL;

            END IF;

        END; -- Missing Customers from CLSUSAVarian on Price FX Target Customer Master

        -- Missing Customers on Price FX Customer Master

        BEGIN
            n_recordcount := 0;
            SELECT
                COUNT(*)
            INTO n_recordcount
            FROM
                xxso_m_clscanvariant
                LEFT OUTER JOIN xxso_m_lpmxref ON xxso_m_lpmxref.legacy_account_number = TO_CHAR(xxso_m_clscanvariant.customer_number
                )
                LEFT OUTER JOIN xxso_m_pfxcustomermaster ON 'LPM-' || xxso_m_lpmxref.r12_cust_acct_number = xxso_m_pfxcustomermaster
                .customer_id
            WHERE
                xxso_m_pfxcustomermaster.customer_id IS NULL;

            IF n_recordcount <> 0 THEN
                INSERT INTO xxso_m_migrationprocesserrors VALUES(
                    '0011',
                    '',
                    '0011 - ERROR: '
                    || TO_CHAR(n_recordcount)
                    || 'Missing Customers on Price FX Customer Master'
                );

                INSERT INTO xxso_m_migrationprocesserrors
                    SELECT DISTINCT
                        '0011',
                        xxso_m_lpmxref.r12_cust_acct_number,
                        'Missing Customer '
                        || xxso_m_lpmxref.r12_cust_acct_number
                        || ' from CLCANVariant on Price FX Customer Master.'
                    FROM
                        xxso_m_clscanvariant
                        LEFT OUTER JOIN xxso_m_lpmxref ON xxso_m_lpmxref.legacy_account_number = TO_CHAR(xxso_m_clscanvariant.customer_number
                        )
                        LEFT JOIN xxso_m_pfxcustomermaster ON 'LPM-' || xxso_m_lpmxref.r12_cust_acct_number = xxso_m_pfxcustomermaster
                        .customer_id
                    WHERE
                        xxso_m_pfxcustomermaster.customer_id IS NULL;

            END IF;

        END; --Missing Customers on Price FX Customer Master

        -- Missing Products from CLSUSAVariant on Target Price FX Product Master

        BEGIN
            n_recordcount := 0;
            SELECT
                COUNT(*)
            INTO n_recordcount
            FROM
                xxso_m_clsusavariant left
                JOIN xxso_m_pfxitemmaster ON 'LPM-'
                                             || substr(TO_CHAR(xxso_m_clsusavariant.item),1,5)= xxso_m_pfxitemmaster.product_id
            WHERE
                xxso_m_pfxitemmaster.product_id IS NULL;

            IF n_recordcount <> 0 THEN
                INSERT INTO xxso_m_migrationprocesserrors VALUES(
                    '0012',
                    '',
                    '0012 - ERROR: '
                    || TO_CHAR(n_recordcount)
                    || 'Missing Products from CLSUSAVariant on Target Price FX Product Master'
                );

                INSERT INTO xxso_m_migrationprocesserrors
                    SELECT DISTINCT
                        '0012',
                        xxso_m_clsusavariant.item,
                        'Missing Item '
                        || xxso_m_clsusavariant.item
                        || ' FROM CLSUSAVariant on Target Price FX Product Master.'
                    FROM
                        xxso_m_clsusavariant left
                        JOIN xxso_m_pfxitemmaster ON 'LPM-'
                                                     || substr(TO_CHAR(xxso_m_clsusavariant.item),1,5)= xxso_m_pfxitemmaster.product_id
                    WHERE
                        xxso_m_pfxitemmaster.product_id IS NULL;

            END IF;

        END; -- Missing Products from CLSUSAVariant on Target Price FX Product Master

        -- Missing Products from CLSCANVariant on Target Price FX Product Master 

        BEGIN
            n_recordcount := 0;
            SELECT
                COUNT(*)
            INTO n_recordcount
            FROM
                xxso_m_clscanvariant
                LEFT OUTER JOIN xxso_m_pfxitemmaster ON 'LPM-'
                                                        || substr(TO_CHAR(xxso_m_clscanvariant.item),1,5)= xxso_m_pfxitemmaster.product_id
            WHERE
                xxso_m_pfxitemmaster.product_id IS NULL;

            IF n_recordcount <> 0 THEN
                INSERT INTO xxso_m_migrationprocesserrors VALUES(
                    '0013',
                    '',
                    '0013 - ERROR: '
                    || TO_CHAR(n_recordcount)
                    || 'Missing Products from CLSCANVariant on Target Price FX Product Master'
                );

                INSERT INTO xxso_m_migrationprocesserrors
                    SELECT DISTINCT
                        '0013',
                        xxso_m_clscanvariant.item,
                        'Missing Item '
                        || xxso_m_clscanvariant.item
                        || ' FROM CLSUCANVariant on Target Price FX Product Master.'
                    FROM
                        xxso_m_clscanvariant left
                        JOIN xxso_m_pfxitemmaster ON 'LPM-'
                                                     || substr(TO_CHAR(xxso_m_clscanvariant.item),1,5)= xxso_m_pfxitemmaster.product_id
                    WHERE
                        xxso_m_pfxitemmaster.product_id IS NULL;

            END IF;

        END; -- Missing Products from CLSCANVariant on Target Price FX Product Master

        -- More than one record by Legacy Account Number on LPMxRef

        BEGIN
            n_speccount := 0;
            SELECT
                COUNT(DISTINCT xxso_m_lpmxref.legacy_account_number)
            INTO n_speccount
            FROM
                xxso_m_lpmxref
            WHERE
                xxso_m_lpmxref.legacy_account_number IN(
                    SELECT
                        xxso_m_lpmxref.legacy_account_number
                    FROM
                        xxso_m_lpmxref
                    WHERE
                        xxso_m_lpmxref.legacy_active_flag = 'ACTIVE'
                    GROUP BY
                        xxso_m_lpmxref.legacy_account_number
                    HAVING
                        COUNT(xxso_m_lpmxref.legacy_account_number)> 1
                );

            IF n_speccount <> 0 THEN
                INSERT INTO xxso_m_migrationprocesserrors VALUES(
                    '0014',
                    '',
                    '0014 - ERROR: More than one record by Legacy Account Number on LPMxRef'
                );

                INSERT INTO xxso_m_migrationprocesserrors
                    SELECT
                        '0014',
                        xxso_m_lpmxref.legacy_account_number,
                        xxso_m_lpmxref.legacy_account_number
                        || ' appears '
                        || TO_CHAR(COUNT(xxso_m_lpmxref.legacy_account_number))
                        || ' times on LPMxRef.'
                    FROM
                        xxso_m_lpmxref
                    WHERE
                        xxso_m_lpmxref.legacy_active_flag = 'ACTIVE'
                    GROUP BY
                        '0014',
                        xxso_m_lpmxref.legacy_account_number
                    HAVING
                        COUNT(xxso_m_lpmxref.legacy_account_number)> 1;

                n_execute := 0;
            END IF;

        END; -- More than one record by Legacy Account Number on LPMxRef

        -- Missing Customers from PAB Extract on PROD1 Customer Master

        BEGIN
            n_recordcount := 0;
            SELECT
                COUNT(*)
            INTO n_recordcount
            FROM
                xxso_m_pabextract
                LEFT OUTER JOIN xxso_m_pfxcustomermaster_src ON xxso_m_pabextract.cust = xxso_m_pfxcustomermaster_src.customer_num_cd
            WHERE
                xxso_m_pfxcustomermaster_src.customer_num_cd IS NULL;

            IF n_recordcount <> 0 THEN
                INSERT INTO xxso_m_migrationprocesserrors VALUES(
                    '0015',
                    '',
                    '0015 - ERROR: '
                    || TO_CHAR(n_recordcount)
                    || 'Missing Customers from PAB Extract on PROD1 Customer Master'
                );

                INSERT INTO xxso_m_migrationprocesserrors
                    SELECT DISTINCT
                        '0015',
                        xxso_m_pabextract.cust,
                        'Missing Customer '
                        || xxso_m_pabextract.cust
                        || ' FROM PAB Extract on PROD1 Customer Master.'
                    FROM
                        xxso_m_pabextract
                        LEFT OUTER JOIN xxso_m_pfxcustomermaster_src ON xxso_m_pabextract.cust = xxso_m_pfxcustomermaster_src.customer_num_cd
                    WHERE
                        xxso_m_pfxcustomermaster_src.customer_num_cd IS NULL;

            END IF;

        END; -- Missing Customers from PAB Extract on PROD1 Customer Master

        --  Missing Customers from PAB Extract on Customer xReference

        BEGIN
            n_recordcount := 0;
            SELECT
                COUNT(*)
            INTO n_recordcount
            FROM
                xxso_m_pabextract left
                JOIN xxso_m_lpmxref ON xxso_m_pabextract.cust = xxso_m_lpmxref.legacy_account_number
            WHERE
                xxso_m_lpmxref.legacy_account_number IS NULL;

            IF n_recordcount <> 0 THEN
                INSERT INTO xxso_m_migrationprocesserrors VALUES(
                    '0016',
                    '',
                    '0016 - ERROR: Missing Customers from PAB Extract on Customer xReference'
                );

                INSERT INTO xxso_m_migrationprocesserrors
                    SELECT DISTINCT
                        '0016',
                        xxso_m_pabextract.cust,
                        'Missing Customer '
                        || xxso_m_pabextract.cust
                        || ' FROM PAB Extract on Customer xReference.'
                    FROM
                        xxso_m_pabextract left
                        JOIN xxso_m_lpmxref ON xxso_m_pabextract.cust = xxso_m_lpmxref.legacy_account_number
                    WHERE
                        xxso_m_lpmxref.legacy_account_number IS NULL;

            END IF;

        END; --  Missing Customers from PAB Extract on Customer xReference

        --More than one record by spec on Target Product Master

        BEGIN
            n_speccount := 0;
            SELECT
                COUNT(DISTINCT product_id)
            INTO n_speccount
            FROM
                xxso_m_pfxitemmaster
            WHERE
                xxso_m_pfxitemmaster.product_id IN(
                    SELECT
                        xxso_m_pfxitemmaster.product_id
                    FROM
                        xxso_m_pfxitemmaster
                    GROUP BY
                        xxso_m_pfxitemmaster.product_id
                    HAVING
                        COUNT(xxso_m_pfxitemmaster.product_id)> 1
                );

            IF n_speccount <> 0 THEN
                INSERT INTO xxso_m_migrationprocesserrors VALUES(
                    '0017',
                    '',
                    '0017 - ERROR: More than one record by spec on Target Product Master.'
                );

                INSERT INTO xxso_m_migrationprocesserrors
                    SELECT
                        '0017',
                        TO_CHAR(xxso_m_pfxitemmaster.product_id),
                        'Sku '
                        || TO_CHAR(xxso_m_pfxitemmaster.product_id)
                        || ' appears '
                        || TO_CHAR(COUNT(xxso_m_pfxitemmaster.product_id))
                        || ' times on Target Item Master.'
                    FROM
                        xxso_m_pfxitemmaster
                    GROUP BY
                        '0017',
                        xxso_m_pfxitemmaster.product_id,
                        TO_CHAR(xxso_m_pfxitemmaster.product_id)
                    HAVING
                        COUNT(xxso_m_pfxitemmaster.product_id)> 1;

            END IF;

        END; --More than one record by spec on Target Product Master

    END; --xxso_checkerrors

    PROCEDURE xxso_m_popoutp2lpmcompchar AS
        n_speccount NUMBER;
    BEGIN
        INSERT INTO xxso_m_outp2lpmcompcharact
            SELECT
                xxso_m_lpmcomponentcharact.product_id,
                nvl(xxso_m_lpmcomponentcharact_src.pricingfamily,' '),
                xxso_m_lpmcomponentcharact.productgroup,
                xxso_m_lpmcomponentcharact.specnumber,
                xxso_m_lpmcomponentcharact.itemdescription,
                xxso_m_lpmcomponentcharact.itemnumber,
                xxso_m_lpmcomponentcharact.activefrom,
                nvl(xxso_m_lpmcomponentcharact_src.appearance,' '),
                nvl(xxso_m_lpmcomponentcharact_src.caliper_weight,' '),
                nvl(xxso_m_lpmcomponentcharact_src.coating,' '),
                nvl(xxso_m_lpmcomponentcharact_src.composition,' '),
                nvl(xxso_m_lpmcomponentcharact_src.other,' '),
                nvl(xxso_m_lpmcomponentcharact_src.base,' '),
                nvl(xxso_m_lpmcomponentcharact_src.datacapacity,' '),
                nvl(xxso_m_lpmcomponentcharact_src.midply,' '),
                nvl(xxso_m_lpmcomponentcharact_src.nfc,' '),
                nvl(xxso_m_lpmcomponentcharact_src.pharma,' '),
                nvl(xxso_m_lpmcomponentcharact_src.printtech,' '),
                nvl(xxso_m_lpmcomponentcharact_src.tamperevident,' '),
                nvl(xxso_m_lpmcomponentcharact_src.visualindicator,' '),
                nvl(xxso_m_lpmcomponentcharact_src.weld,' '),
                nvl(xxso_m_lpmcomponentcharact_src.adhesivedescription1,' '),
                nvl(xxso_m_lpmcomponentcharact_src.adhesivebase1,' '),
                nvl(xxso_m_lpmcomponentcharact_src.ctwt1,' '),
                nvl(xxso_m_lpmcomponentcharact_src.patterngum,' '),
                nvl(xxso_m_lpmcomponentcharact_src.linerdescription1,' '),
                nvl(xxso_m_lpmcomponentcharact_src.linerbase1,' '),
                nvl(xxso_m_lpmcomponentcharact_src.release1,' '),
                nvl(xxso_m_lpmcomponentcharact_src.adhesivedescription2,' '),
                nvl(xxso_m_lpmcomponentcharact_src.adhesivebase2,' '),
                nvl(xxso_m_lpmcomponentcharact_src.ctwt2,' '),
                ''
            FROM
                xxso_m_lpmcomponentcharact
                LEFT OUTER JOIN xxso_m_lpmcomponentcharact_src ON 'LPM-' || xxso_m_lpmcomponentcharact_src.specnumber = xxso_m_lpmcomponentcharact
                .product_id
            ORDER BY
                xxso_m_lpmcomponentcharact.product_id;

        n_speccount := 0;
        SELECT
            COUNT(DISTINCT product_id)
        INTO n_speccount
        FROM
            xxso_m_outp2lpmcompcharact
        WHERE
            product_id IN(
                SELECT
                    product_id
                FROM
                    xxso_m_outp2lpmcompcharact
                GROUP BY
                    product_id
                HAVING
                    COUNT(product_id)> 1
            );

        IF n_speccount <> 0 THEN
            INSERT INTO xxso_m_migrationprocesserrors VALUES(
                '0201',
                '',
                '0201 - ERROR: More than one record by spec on OutputP2LPMComponentCharacteristics'
            );

            INSERT INTO xxso_m_migrationprocesserrors
                SELECT
                    '0201',
                    TO_CHAR(product_id),
                    'sku '
                    || TO_CHAR(product_id)
                    || ' appears '
                    || TO_CHAR(COUNT(product_id))
                    || ' times on OutputP2LPMComponentCharacteristics.'
                FROM
                    xxso_m_outp2lpmcompcharact
                GROUP BY
                    product_id,
                    '0201',
                    TO_CHAR(product_id)
                HAVING
                    COUNT(product_id)> 1;

        END IF;

    END; --xxso_popoutp2lpmcompchar

    PROCEDURE xxso_m_popoutp2lpmother AS
        n_speccount NUMBER;
    BEGIN
        INSERT INTO xxso_m_outp2lpmotherprodchar
            SELECT
                xxso_m_lpmotherprodcharact.product_id,
                xxso_m_lpmotherprodcharact_src.pricingfamily,
                xxso_m_lpmotherprodcharact.productgroup,
                xxso_m_lpmotherprodcharact.specnumber,
                xxso_m_lpmotherprodcharact.specdescription,
                xxso_m_lpmotherprodcharact.itemnumber,
                xxso_m_lpmotherprodcharact_src.productline,
                xxso_m_lpmotherprodcharact.activefrom,
                xxso_m_lpmotherprodcharact_src.linerdescription2,
                xxso_m_lpmotherprodcharact_src.linerbase2,
                xxso_m_lpmotherprodcharact_src.release2,
                xxso_m_lpmotherprodcharact_src.miscupchargecode,
                xxso_m_lpmotherprodcharact_src.miscupchargecode2,
                xxso_m_lpmotherprodcharact_src.miscupchargecode3,
                xxso_m_lpmotherprodcharact_src.widthfamily,
                xxso_m_lpmotherprodcharact_src.bestavailablestockstatus,
                nvl(xxso_m_lpmotherprodcharact_src.manualfloorprice,0),
                xxso_m_lpmotherprodcharact_src.productstrategy,
                xxso_m_lpmotherprodcharact_src.pricerestrictedreasoncode,
                xxso_m_lpmotherprodcharact_src.item_status_code,
                xxso_m_lpmotherprodcharact_src.readyforpricing,
                xxso_m_lpmotherprodcharact_src.attributesfilled,
                xxso_m_lpmotherprodcharact_src.flagblock,
                xxso_m_lpmotherprodcharact_src.itemuom,
                nvl(xxso_m_lpmotherprodcharact_src.conversionfactor,0),
                '',
                xxso_m_lpmotherprodcharact.itemdescription,
                xxso_m_lpmotherprodcharact_src.attr11,
                xxso_m_lpmotherprodcharact_src.attr21,
                xxso_m_lpmotherprodcharact_src.attr23,
                xxso_m_lpmotherprodcharact_src.freightrate,
                xxso_m_lpmotherprodcharact_src.attr30
            FROM
                xxso_m_lpmotherprodcharact
                LEFT OUTER JOIN xxso_m_lpmotherprodcharact_src ON 'LPM-' || xxso_m_lpmotherprodcharact_src.specnumber = xxso_m_lpmotherprodcharact
                .product_id
            ORDER BY
                xxso_m_lpmotherprodcharact.product_id;

        n_speccount := 0;
        SELECT
            COUNT(DISTINCT product_id)
        INTO n_speccount
        FROM
            xxso_m_outp2lpmotherprodchar
        WHERE
            product_id IN(
                SELECT
                    product_id
                FROM
                    xxso_m_outp2lpmotherprodchar
                GROUP BY
                    product_id
                HAVING
                    COUNT(product_id)> 1
            );

        IF n_speccount <> 0 THEN
            INSERT INTO xxso_m_migrationprocesserrors VALUES(
                '0301',
                '',
                'ERROR: More than one record by spec on OutputP2LPMOtherProductCharacteristics'
            );

            INSERT INTO xxso_m_migrationprocesserrors
                SELECT
                    '0301',
                    TO_CHAR(product_id),
                    'sku '
                    || TO_CHAR(product_id)
                    || ' appears '
                    || TO_CHAR(COUNT(product_id))
                    || ' times on OutputP2LPMOtherProductCharacteristics.'
                FROM
                    xxso_m_outp2lpmotherprodchar
                GROUP BY
                    product_id,
                    '0301',
                    TO_CHAR(product_id)
                HAVING
                    COUNT(product_id)> 1;

        END IF;

    END; --xxso.xxso_popoutp2lpmother

    PROCEDURE xxso_m_pop_out_reference AS
    BEGIN
        INSERT INTO xxso_m_outproductreference
            SELECT
                xxso_m_pfxitemmaster.spec_cd,
                xxso_m_pfxitemmaster.product_id
            FROM
                xxso_m_pfxitemmaster
            WHERE
                product_id LIKE 'LPM-%';

	/* PROCESS Output Item Reference ***************************************************************************************************************/

        INSERT INTO xxso_m_outitemreference
            SELECT
                xxso_m_pfxitemmaster.spec_cd,
                xxso_m_pfxitemmaster.spec_cd
            FROM
                xxso_m_pfxitemmaster
            WHERE
                product_id LIKE 'LPM-%';

	/* PROCESS Output Customer Reference ***************************************************************************************************************/

        INSERT INTO xxso_m_outcustomerreference
            SELECT
                'CLSCLS.COMMON' || xxso_m_lpmxref.legacy_account_number,
                'LPM-' || xxso_m_lpmxref.r12_cust_acct_number
            FROM
                xxso_m_lpmxref;

	/* PROCESS Output National Account Reference ***************************************************************************************************************/

        INSERT INTO xxso_m_outnationalaccountref
            SELECT
                xxso_m_lpmxrefnationalaccount.legacy_pricing_group_number,
                xxso_m_lpmxrefnationalaccount.oracle_account_number
            FROM
                xxso_m_lpmxrefnationalaccount;

    END;

    PROCEDURE xxso_m_pop_out_negotiated AS
    BEGIN
        INSERT INTO xxso_m_outnegotiatedplstaging
            SELECT
                CASE
                    WHEN xxso_m_clsusavariant.national_account <> '0' THEN
                        xxso_m_clsusavariant.national_account
                    ELSE
                        xxso_m_clsusavariant.national_account
                END, --National Account Number
                'CLSCLS.COMMON' || xxso_m_clsusavariant.customer_number, -- Customerid
                'Yes', -- Active
                'MQIL1-' || xxso_m_clsusavariant.quote_number, /*verify*/
                'MLID1-US-'
                || TO_CHAR(ROW_NUMBER()OVER(
                    ORDER BY
                        xxso_m_clsusavariant.quote_number
                )+ 100000), --'MLID-' || CAST(ROW_NUMBER() over (order by CLSUSAVariant.[QUOTE NUMBER ]) AS BIGINT) + 100000) AS 'LineItemId',
                'Negotiated', -- Quote Type
                xxso_m_clsusavariant.customer_name,
                CASE
                    WHEN length(xxso_m_clsusavariant.customer_number)> 5 THEN
                        substr(TO_CHAR(xxso_m_clsusavariant.customer_number),1,5)
                    ELSE
                        TO_CHAR(xxso_m_clsusavariant.customer_number)
                END,
                CASE
                    WHEN length(TO_CHAR(xxso_m_clsusavariant.item))= 9  THEN
                        substr(TO_CHAR(xxso_m_clsusavariant.item),1,5)
                    WHEN length(TO_CHAR(xxso_m_clsusavariant.item))= 8  THEN
                        substr(TO_CHAR(xxso_m_clsusavariant.item),1,4)
                    WHEN length(TO_CHAR(xxso_m_clsusavariant.item))= 7  THEN
                        substr(TO_CHAR(xxso_m_clsusavariant.item),1,3)
                    ELSE
                        TO_CHAR(xxso_m_clsusavariant.item)
                END, --AS 'Item',
                'SPEC',
                'LPM',
                xxso_m_clsusavariant.fasson_price_pqs_only,
                xxso_m_clsusavariant.currency,
                TO_DATE(substr(TO_CHAR(xxso_m_clsusavariant.effective_date),1,4)
                        || substr(TO_CHAR(xxso_m_clsusavariant.effective_date),5,2)
                        || substr(TO_CHAR(xxso_m_clsusavariant.effective_date),7,2),'yyyymmdd'), --  AS 'EffectiveDate',
                add_months(TO_DATE(substr(TO_CHAR(xxso_m_clsusavariant.effective_date),1,4)
                                   || substr(TO_CHAR(xxso_m_clsusavariant.effective_date),5,2)
                                   || substr(TO_CHAR(xxso_m_clsusavariant.effective_date),7,2),'yyyymmdd'),18), --CONVERT( VARCHAR(10), dateadd(month,18, getdate()),120) AS 'ExpiryDate',
                'MSI',
                0, -- AS 'FreightRates', ??????			
                xxso_m_clsusavariant.freight_term, --] AS 'FreightTerms',
                '', -- AS 'ProjectName',
                '', -- AS 'QuoteComment',
                '', --AS 'ProjectNumber',
                'No',      --as 'ApplyQtyBreakStr',
                xxso_m_clsusavariant.moq, -- AS 'MOQ',
                CASE
                    WHEN xxso_m_clsusavariant.short_roll_waive = 'N' THEN
                        'No'
                    ELSE
                        'Yes'
                END, -- AS 'ShortRollWaive',
                xxso_m_clsusavariant.item_description, -- ] as 'SpecDesc',
                '', -- as 'SpecDesc2',
                CASE
                    WHEN xxso_m_clsusavariant.trim_flag = 'N' THEN
                        'No'
                    ELSE
                        'Yes'
                END, -- AS 'TrimWaive',
                '', -- AS 'attribute27',
                '', -- AS 'Length',
                xxso_m_clsusavariant.max_trim_width,-- AS 'TrimMax',
                'DEAL', -- AS 'QuoteStatus',
                '', -- AS 'OriginalExpirationDate',
                SYSDATE(), --CONVERT( VARCHAR(10), getdate(),120) AS 'SystemAddedDate',
                'Initial Load', -- AS 'SystemUpdateReason',
                '', -- AS 'ReasonForManualPriceChange',
                nvl(xxso_m_pfxitemmaster_src.prod_group_cd,''), -- AS 'PricingSubGroup',
                0, -- AS 'QuoteDiscountPercentage',
                'No', -- AS 'SheetingWaive',
                'COMMERCIAL', -- AS 'LifeCycleStatus',
                '', -- AS 'QuoteDescription',
                0, -- AS 'CustomerTierPercentage',
                'Yes', -- AS 'UpdateOnlyThisCustomer',
                'MQ' || xxso_m_clsusavariant.quote_number, --CONCAT(	'MQ-' , CAST(CLSUSAVariant.[QUOTE NUMBER ] AS BIGINT) ) AS 'QuoteUniqueId',
                'Initial Load', -- AS 'ApprovedBy',
                SYSDATE(), --convert( varchar(10), GETDATE(),120) as 'ApprovedDate',
                'MQ-' || xxso_m_clsusavariant.quote_number, --CONCAT(	'MQ-' , CAST(CLSUSAVariant.[QUOTE NUMBER ] AS BIGINT) ) AS 'Name_w/o_Revision',
                '', -- as 'ProductComment',
                '', -- AS 'attribute48',
                '', -- AS 'attribute49',
                ''
            FROM
                xxso_m_clsusavariant,
                xxso_m_pfxitemmaster_src,
                xxso_m_lpmxref
            WHERE
                1 = 1
                AND 'CLSCLS.COMMON'
                    || substr(xxso_m_clsusavariant.item,1,5)= xxso_m_pfxitemmaster_src.product_id
                AND TO_CHAR(xxso_m_clsusavariant.customer_number)= xxso_m_lpmxref.legacy_account_number
                AND xxso_m_lpmxref.legacy_active_flag = 'ACTIVE'
                --AND   NOT ( xxso_m_clsusavariant.customer_name LIKE '%AVERY DENNISON%' )
                --AND   NOT ( xxso_m_clsusavariant.customer_name LIKE '%AVERY-DENNISON%' )
                AND NOT(xxso_m_clsusavariant.customer_name LIKE '%FASSON%')
                AND NOT(xxso_m_clsusavariant.customer_name LIKE '%FRNA%')
                AND NOT(xxso_m_clsusavariant.customer_name LIKE '%AVERY MATERIALS GROUP%')
                AND NOT(xxso_m_clsusavariant.customer_name LIKE '%AD OFFICE PRODUCTS GMBH%')
                AND NOT(xxso_m_clsusavariant.customer_name LIKE '%AVERY(H KONG)LTD TAIWAN BRANCH%')
                AND NOT(xxso_m_clsusavariant.customer_name LIKE '%AVERY CHILE%')
                AND NOT(xxso_m_clsusavariant.customer_name LIKE '%AVERY MATERIALS GROUP%')
                AND NOT(xxso_m_clsusavariant.item LIKE 'X%')
                AND NOT(xxso_m_clsusavariant.item LIKE 'S%')
            UNION
            SELECT
                CASE
                    WHEN xxso_m_clscanvariant.national_account <> '0' THEN
                        xxso_m_clscanvariant.national_account
                    ELSE
                        xxso_m_clscanvariant.national_account
                END, --National Account Number
                'CLSCLS.COMMON' || xxso_m_clscanvariant.customer_number, -- Customerid
                'Yes', -- Active
                'MQIL1-' || xxso_m_clscanvariant.quote_number, /*verify*/
                'MLID1-CA-'
                || TO_CHAR(ROW_NUMBER()OVER(
                    ORDER BY
                        xxso_m_clscanvariant.quote_number
                )+ 100000), --'MLID-' || CAST(ROW_NUMBER() over (order by CLSUSAVariant.[QUOTE NUMBER ]) AS BIGINT) + 100000) AS 'LineItemId',
                'Negotiated', -- Quote Type
                xxso_m_clscanvariant.customer_name,
                CASE
                    WHEN length(xxso_m_clscanvariant.customer_number)> 5 THEN
                        substr(TO_CHAR(xxso_m_clscanvariant.customer_number),1,5)
                    ELSE
                        TO_CHAR(xxso_m_clscanvariant.customer_number)
                END,
                CASE
                    WHEN length(TO_CHAR(xxso_m_clscanvariant.item))= 9  THEN
                        substr(TO_CHAR(xxso_m_clscanvariant.item),1,5)
                    WHEN length(TO_CHAR(xxso_m_clscanvariant.item))= 8  THEN
                        substr(TO_CHAR(xxso_m_clscanvariant.item),1,4)
                    WHEN length(TO_CHAR(xxso_m_clscanvariant.item))= 7  THEN
                        substr(TO_CHAR(xxso_m_clscanvariant.item),1,3)
                    ELSE
                        TO_CHAR(xxso_m_clscanvariant.item)
                END, --AS 'Item',
                'SPEC',
                'LPM',
                xxso_m_clscanvariant.fasson_price_only,
                xxso_m_clscanvariant.currency,
                TO_DATE(substr(TO_CHAR(xxso_m_clscanvariant.effective_date),1,4)
                        || substr(TO_CHAR(xxso_m_clscanvariant.effective_date),5,2)
                        || substr(TO_CHAR(xxso_m_clscanvariant.effective_date),7,2),'yyyymmdd'), --  AS 'EffectiveDate',
                add_months(TO_DATE(substr(TO_CHAR(xxso_m_clscanvariant.effective_date),1,4)
                                   || substr(TO_CHAR(xxso_m_clscanvariant.effective_date),5,2)
                                   || substr(TO_CHAR(xxso_m_clscanvariant.effective_date),7,2),'yyyymmdd'),18), --CONVERT( VARCHAR(10), dateadd(month,18, getdate()),120) AS 'ExpiryDate',
                'MSI',
                0, -- AS 'FreightRates', ??????			
                xxso_m_clscanvariant.freight_term, --] AS 'FreightTerms',
                '', -- AS 'ProjectName',
                '', -- AS 'QuoteComment',
                '', --AS 'ProjectNumber',
                'No',      --as 'ApplyQtyBreakStr',
                xxso_m_clscanvariant.moq, -- AS 'MOQ',
                CASE
                    WHEN xxso_m_clscanvariant.short_roll_waive = 'N' THEN
                        'No'
                    ELSE
                        'Yes'
                END, -- AS 'ShortRollWaive',
                xxso_m_clscanvariant.item_description, -- ] as 'SpecDesc',
                '', -- as 'SpecDesc2',
                CASE
                    WHEN xxso_m_clscanvariant.trim_flag = 'N' THEN
                        'No'
                    ELSE
                        'Yes'
                END, -- AS 'TrimWaive',
                '', -- AS 'attribute27',
                '', -- AS 'Length',
                xxso_m_clscanvariant.max_trim_width,-- AS 'TrimMax',
                'DEAL', -- AS 'QuoteStatus',
                '', -- AS 'OriginalExpirationDate',
                SYSDATE(), --CONVERT( VARCHAR(10), getdate(),120) AS 'SystemAddedDate',
                'Initial Load', -- AS 'SystemUpdateReason',
                '', -- AS 'ReasonForManualPriceChange',
                nvl(xxso_m_pfxitemmaster_src.prod_group_cd,''), -- AS 'PricingSubGroup',
                0, -- AS 'QuoteDiscountPercentage',
                'No', -- AS 'SheetingWaive',
                'COMMERCIAL', -- AS 'LifeCycleStatus',
                '', -- AS 'QuoteDescription',
                0, -- AS 'CustomerTierPercentage',
                'Yes', -- AS 'UpdateOnlyThisCustomer',
                'MQ' || xxso_m_clscanvariant.quote_number, --CONCAT(	'MQ-' , CAST(CLSUSAVariant.[QUOTE NUMBER ] AS BIGINT) ) AS 'QuoteUniqueId',
                'Initial Load', -- AS 'ApprovedBy',
                SYSDATE(), --convert( varchar(10), GETDATE(),120) as 'ApprovedDate',
                'MQ-' || xxso_m_clscanvariant.quote_number, --CONCAT(	'MQ-' , CAST(CLSUSAVariant.[QUOTE NUMBER ] AS BIGINT) ) AS 'Name_w/o_Revision',
                '', -- as 'ProductComment',
                '', -- AS 'attribute48',
                '', -- AS 'attribute49',
                ''
            FROM
                xxso_m_clscanvariant,
                xxso_m_pfxitemmaster_src,
                xxso_m_lpmxref
            WHERE
                1 = 1
                AND 'CLSCLS.COMMON'
                    || substr(xxso_m_clscanvariant.item,1,5)= xxso_m_pfxitemmaster_src.product_id
                AND TO_CHAR(xxso_m_clscanvariant.customer_number)= xxso_m_lpmxref.legacy_account_number
                AND xxso_m_lpmxref.legacy_active_flag = 'ACTIVE'
                --AND   NOT ( xxso_m_clscanvariant.customer_name LIKE '%AVERY DENNISON%' )
                --AND   NOT ( xxso_m_clscanvariant.customer_name LIKE '%AVERY-DENNISON%' )
                AND NOT(xxso_m_clscanvariant.customer_name LIKE '%FASSON%')
                AND NOT(xxso_m_clscanvariant.customer_name LIKE '%FRNA%')
                AND NOT(xxso_m_clscanvariant.customer_name LIKE '%AVERY MATERIALS GROUP%')
                AND NOT(xxso_m_clscanvariant.customer_name LIKE '%AD OFFICE PRODUCTS GMBH%')
                AND NOT(xxso_m_clscanvariant.customer_name LIKE '%AVERY(H KONG)LTD TAIWAN BRANCH%')
                AND NOT(xxso_m_clscanvariant.customer_name LIKE '%AVERY CHILE%')
                AND NOT(xxso_m_clscanvariant.customer_name LIKE '%AVERY MATERIALS GROUP%')
                AND NOT(xxso_m_clscanvariant.item LIKE 'X%')
                AND NOT(xxso_m_clscanvariant.item LIKE 'S%');

    END;

    PROCEDURE xxso_m_pop_out_pab AS
    BEGIN
        INSERT INTO xxso_m_outnegotiatedpabstaging
            SELECT
                xxso_m_pfxcustomermaster_src.national_acct_num_cd, -- AS 'NationalAccountNumber',
                'CLSCLS.COMMON' || xxso_m_pabextract.cust, -- AS 'Customer_ID',
                'Yes', -- AS 'Active',
                'MQPABIL-'
                || TO_CHAR(ROW_NUMBER()OVER(
                    ORDER BY
                        xxso_m_pabextract.cust
                )), -- AS 'Quote',
                'MLPABID-'
                || TO_CHAR(ROW_NUMBER()OVER(
                    ORDER BY
                        xxso_m_pabextract.cust
                )+ 100000), --  AS 'LineItemId',
                'Negotiated/PAB', -- AS 'QuoteType',
                xxso_m_pfxcustomermaster_src.company_name, -- AS 'CustomerName',
                xxso_m_pabextract.cust, -- AS 'CustomerNumber',
                xxso_m_pabextract.spec, -- AS 'Item',
                'SPEC', -- AS 'ItemType',
                'LPM', -- AS 'BusinessUnit',
                to_number(xxso_m_pabextract.requested_price), -- AS 'Price',
                'USD', -- AS 'Currency',
                SYSDATE(), -- AS 'EffectiveDate',
                add_months(SYSDATE(),18), -- AS 'ExpiryDate',
                'MSI', -- AS 'UOM',
                '0', -- AS 'FreightRates',			
                xxso_m_pfxcustomermaster_src.freight_term, -- AS 'FreightTerms',
                '', -- AS 'ProjectName',
                '', -- AS 'QuoteComment',
                '', -- AS 'ProjectNumber',
                'No', -- AS 'ApplyQtyBreakStr',
                nvl(xxso_m_pabextract.msi_qty,'0'), -- AS 'MOQ',
                '', -- AS 'ShortRollWaive',
                xxso_m_pfxitemmaster.spec_desc, -- AS 'SpecDesc',
                '', -- AS 'SpecDesc2',
                '', -- AS 'TrimWaive',
                '', -- AS 'attribute27',
                '', -- AS 'Length',
                0, -- AS 'TrimMax',
                'OFFER', -- AS 'QuoteStatus',
                SYSDATE(), -- AS 'OriginalExpirationDate',
                SYSDATE(), -- AS 'SystemAddedDate',
                'Initial Load', -- AS 'SystemUpdateReason',
                '', -- AS 'ReasonForManualPriceChange',
                xxso_m_pfxitemmaster.prod_group_cd, -- AS 'PricingSubGroup',
                0, -- AS 'QuoteDiscountPercentage',
                'No', -- AS 'SheetingWaive',
                'COMMERCIAL', -- AS 'LifeCycleStatus',
                substr(xxso_m_pabextract.comments,1,70), -- AS 'QuoteDescription',
                0, --  AS 'CustomerTierPercentage',
                'Yes', -- AS 'UpdateOnlyThisCustomer',
                'MQPABIL-'
                || TO_CHAR(ROW_NUMBER()OVER(
                    ORDER BY
                        xxso_m_pabextract.cust
                )),  -- AS 'QuoteUniqueId',
                'Initial Load', -- AS 'ApprovedBy',
                SYSDATE(), -- AS 'ApprovedDate',
                'MQPABIL-'
                || TO_CHAR(ROW_NUMBER()OVER(
                    ORDER BY
                        xxso_m_pabextract.cust
                )), -- AS 'Name_w/o_Revision',
                '', -- AS 'ProductComment',
                '', -- AS 'attribute48',
                '', --  AS 'attribute49',
                '' -- AS 'attribute50'
            FROM
                xxso_m_pabextract,
                xxso_m_pfxcustomermaster_src,
                xxso_m_pfxitemmaster
            WHERE
                1 = 1
                AND xxso_m_pabextract.cust = xxso_m_pfxcustomermaster_src.customer_num_cd
                AND 'LPM-' || xxso_m_pabextract.spec = xxso_m_pfxitemmaster.product_id
            ORDER BY
                xxso_m_pabextract.cust;

    END;

    PROCEDURE xxso_m_pop_out_transferprices AS
    BEGIN
        INSERT INTO xxso_m_outtransferprice
            SELECT
                xxso_m_pfxitemmaster.product_id, -- "PRODUCT_ID" VARCHAR2(50 BYTE),  
                xxso_m_transferprices.price, --"LIST_PRICE" NUMBER, 
                xxso_m_transferprices.price * 1.33, -- "list_price_cad" NUMBER, 
                xxso_m_pfxitemmaster.spec_cd, -- "ITEM_NUMBER" VARCHAR2(50 BYTE), 
                'MSI', -- "UOM" VARCHAR2(20 BYTE), 
                'USD', -- "CURRENCY" VARCHAR2(20 BYTE), 
                SYSDATE(), -- "COLUMN4" DATE, 
                add_months(SYSDATE(),12), -- "EXPIRATION_DATE" DATE, 
                'SPEC' -- "ITEM_TYPE" VARCHAR2(20 BYT 
            FROM
                xxso_m_transferprices,
                xxso_m_pfxitemmaster
            WHERE
                xxso_m_transferprices.spec = xxso_m_pfxitemmaster.spec_cd;

    END;

    PROCEDURE xxso_m_print_counts AS
        n_row_count NUMBER;
    BEGIN
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_clsusavariant;

        dbms_output.put_line('00 - Count XXSO_M_CLSUSAVARIANT ----------------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_clscanvariant;

        dbms_output.put_line('00 - Count XXSO_M_CLSCANVARIANT ----------------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_pabextract;

        dbms_output.put_line('00 - Count XXSO_M_PABEXTRACT -------------------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_ebsitems;

        dbms_output.put_line('10 - Count XXSO_M_EBSITEMS ---------------------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_pfxcustomermaster;

        dbms_output.put_line('10 - Count XXSO_M_PFXCUSTOMERMASTER ------------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_pfxcustomermaster_src;

        dbms_output.put_line('10 - Count XXSO_M_PFXCUSTOMERMASTER_SRC --------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_pfxitemmaster;

        dbms_output.put_line('10 - Count XXSO_M_PFXITEMMASTER ----------------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_pfxitemmaster_src;

        dbms_output.put_line('10 - Count XXSO_M_PFXITEMMASTER_SRC ------------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_lpmcomponentcharact;

        dbms_output.put_line('10 - Count XXSO_M_LPMCOMPONENTCHARACT ----------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_lpmcomponentcharact_src;

        dbms_output.put_line('10 - Count XXSO_M_LPMCOMPONENTCHARACT_SRC ------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_lpmotherprodcharact;

        dbms_output.put_line('10 - Count XXSO_M_LPMOTHERPRODCHARACT ----------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_lpmotherprodcharact_src;

        dbms_output.put_line('10 - Count XXSO_M_LPMOTHERPRODCHARACT_SRC ------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_lpmxref;

        dbms_output.put_line('10 - Count XXSO_M_LPMXREF ----------------------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_lpmxrefnationalaccount;

        dbms_output.put_line('10 - Count XXSO_M_LPMXREFNATIONALACCOUNT -------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_outnegotiatedplstaging;

        dbms_output.put_line('90 - Count XXSO_M_OUTNEGOTIATEDPLSTAGING -------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_outnegotiatedpabstaging;

        dbms_output.put_line('90 - Count XXSO_M_OUTNEGOTIATEDPABSTAGING ------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_outp2lpmcompcharact;

        dbms_output.put_line('90 - Count XXSO_M_OUTP2LPMCOMPCHARACT ----------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_outp2lpmcompcharact_r;

        dbms_output.put_line('90 - Count XXSO_M_OUTP2LPMCOMPCHARACT_R --------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_outp2lpmotherprodchar;

        dbms_output.put_line('90 - Count XXSO_M_OUTP2LPMOTHERPRODCHAR --------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_outproductreference;

        dbms_output.put_line('90 - Count XXSO_M_OUTPRODUCTREFERENCE ----------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_outtransferprice;

        dbms_output.put_line('90 - Count XXSO_M_OUTTRANSFERPRICE -------------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_m_migrationprocesserrors;

        dbms_output.put_line('90 - Count XXSO_M_MIGRATIONPROCESSERRORS -------> ' || TO_CHAR(n_row_count));
    END;

    PROCEDURE xxso_m_check_post_errors AS
    BEGIN
        INSERT INTO xxso_m_migrationprocesserrors
            SELECT
                '0400',
                TO_CHAR(xxso_m_outnegotiatedplstaging.lineitemid),
                'LineItemID '
                || TO_CHAR(xxso_m_outnegotiatedplstaging.lineitemid)
                || ' appears '
                || TO_CHAR(COUNT(xxso_m_outnegotiatedplstaging.lineitemid))
                || ' times on OutNegotiatedPLStaging.'
            FROM
                xxso_m_outnegotiatedplstaging
            GROUP BY
                xxso_m_outnegotiatedplstaging.lineitemid,
                '0400',
                TO_CHAR(xxso_m_outnegotiatedplstaging.lineitemid)
            HAVING
                COUNT(xxso_m_outnegotiatedplstaging.lineitemid)> 1;

        INSERT INTO xxso_m_migrationprocesserrors
            SELECT
                '0400',
                xxso_m_outnegotiatedplstaging.quote,
                'Errors on Negotiated Prices output. Quote ' + xxso_m_outnegotiatedplstaging.quote
                || ' and item '
                || xxso_m_outnegotiatedplstaging.item
                || ' appears '
                || TO_CHAR(COUNT(*))
                || ' times on OutputNegotiatedPricelistStaging.'
            FROM
                xxso_m_outnegotiatedplstaging
            GROUP BY
                xxso_m_outnegotiatedplstaging.quote,
                xxso_m_outnegotiatedplstaging.item,
                '0400'
            HAVING
                COUNT(*)> 1;

        INSERT INTO xxso_m_migrationprocesserrors
            SELECT DISTINCT
                '0400',
                xxso_m_outnegotiatedplstaging.item,
                'Missing Item '
                || xxso_m_outnegotiatedplstaging.item
                || ' on Target Price FX Product Master.'
            FROM
                xxso_m_outnegotiatedplstaging left
                JOIN xxso_m_pfxitemmaster ON 'LPM-' || xxso_m_outnegotiatedplstaging.item = xxso_m_pfxitemmaster.product_id
            WHERE
                xxso_m_pfxitemmaster.product_id IS NULL;

        INSERT INTO xxso_m_migrationprocesserrors
            SELECT DISTINCT
                '0400',
                xxso_m_lpmxref.r12_cust_acct_number,
                'Missing Customer '
                || xxso_m_lpmxref.r12_cust_acct_number
                || ' on Target Price FX Customer Master.'
            FROM
                xxso_m_outnegotiatedplstaging,xxso_m_lpmxref left
                JOIN xxso_m_pfxcustomermaster ON 'LPM-' || xxso_m_lpmxref.r12_cust_acct_number = xxso_m_pfxcustomermaster.customer_id
            WHERE
                TO_CHAR(xxso_m_outnegotiatedplstaging.customernumber)= xxso_m_lpmxref.legacy_account_number
                AND xxso_m_lpmxref.legacy_active_flag = 'ACTIVE'
                AND xxso_m_pfxcustomermaster.customer_id IS NULL;

    END;

    PROCEDURE xxso_m_populateebsitems AS
    BEGIN
        BEGIN
            DELETE FROM xxso_m_ebsitems;

            INSERT INTO xxso_m_ebsitems
                SELECT DISTINCT
                    mp.organization_code               io,
                    msib.segment1                      spec,
                    msib.description                   description,
                    msib.inventory_item_status_code    status,
                    msib.primary_uom_code              uom,
                    msib.item_type                     type,
                    CASE
                        WHEN msib.customer_order_enabled_flag = 'Y'
                             AND msib.internal_order_enabled_flag = 'Y' THEN
                            'Y'
                        WHEN msib.customer_order_enabled_flag = 'Y'
                             AND msib.internal_order_enabled_flag = 'N' THEN
                            'YN'
                        WHEN msib.customer_order_enabled_flag = 'N'
                             AND msib.internal_order_enabled_flag = 'N' THEN
                            'N'
                        WHEN msib.customer_order_enabled_flag = 'N'
                             AND msib.internal_order_enabled_flag = 'Y' THEN
                            'NY'
                        ELSE
                            'Unknown'
                    END orderable,
                    msib.customer_order_flag           order_flag,
                    msib.customer_order_enabled_flag   enabled_flag,
                    msib.creation_date                 creation_date,
                    msib.last_update_date              last_update_date
                FROM
                    --inv.mtl_system_items_b@xxso_erp   msib
                    --LEFT OUTER JOIN apps.mtl_parameters@xxso_erp   mp ON(msib.organization_id = mp.organization_id)
                    inv.mtl_system_items_b@xxso_erpuat   msib
                    LEFT OUTER JOIN apps.mtl_parameters@xxso_erpuat      mp ON(msib.organization_id = mp.organization_id)
                WHERE
                    1 = 1
                    AND msib.item_catalog_group_id IS NOT NULL
                    AND mp.organization_code = 'MST'
                    AND msib.organization_id = 102;

        END;
    END;

    PROCEDURE xxso_r_reconciliation_report AS
        n_row_count NUMBER;
    BEGIN
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_r_pfxquotes;

        dbms_output.put_line('10 - Quotes - PFX Records -------------------------------------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_r_ebsquotes;

        dbms_output.put_line('20 - Quotes - EBS Records--------------------------------------> ' || TO_CHAR(n_row_count));
        SELECT
            COUNT(*)
        INTO n_row_count
        FROM
            xxso_r_missingprices;

        dbms_output.put_line('30 - ERROR - Missing Prices -----------------------------------> ' || TO_CHAR(n_row_count));
    END;

    PROCEDURE xxso_r_recon_build AS
    BEGIN
        xxso.xxso_r_populateebsquotes;
    END xxso_r_recon_build;

    PROCEDURE xxso_r_recon_build_uat AS
    BEGIN
        xxso.xxso_r_populateebsquotes_uat;
    END xxso_r_recon_build_uat;

    FUNCTION xxso_r_compare(
        val1   IN     VARCHAR2,
        val2   IN     VARCHAR2
    )RETURN VARCHAR2 AS
    BEGIN
        IF val1 IS NOT NULL AND val2 IS NOT NULL THEN
            IF ( val1 = 'COLLECT' AND val2 = 'COL' ) OR 
               ( val2 = 'COLLECT' AND val1 = 'COL' ) OR
               ( val1 = 'PREPAID' AND val2 = 'PPD' ) OR 
               ( val2 = 'PREPAID' AND val1 = 'PPD' ) 
            THEN
                RETURN 'OK';
            ELSE
                IF val1 <> val2 THEN
                    RETURN 'Error';
                ELSE
                    RETURN 'OK';
                END IF;
            END IF;
        ELSE
            IF val1 IS NULL AND val2 IS NOT NULL THEN
                RETURN 'Error';
            ELSE
                IF val1 IS NOT NULL AND val2 IS NULL THEN
                    RETURN 'ERROR';
                ELSE
                    RETURN 'OK';
                END IF;
            END IF;
        END IF;
    END xxso_r_compare;

END xxso;

/
