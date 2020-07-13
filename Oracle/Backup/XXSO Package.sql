--------------------------------------------------------
--  File created - Wednesday-July-24-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package XXSO
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "SOBREGON"."XXSO" AS 

  /* TODO enter package declarations (types, exceptions, methods etc) here */
    PROCEDURE xxso_m_clear_migration_tables;

    PROCEDURE xxso_m_perform_manual_fixes;

    PROCEDURE xxso_m_mock_build;

    PROCEDURE xxso_m_check_pre_errors;

    PROCEDURE xxso_m_popoutp2lpmcompchar;

    PROCEDURE xxso_m_popoutp2lpmother;

    PROCEDURE xxso_m_pop_out_reference;

    PROCEDURE xxso_r_populateebsitems;

    PROCEDURE xxso_r_populateebsquotes;

    PROCEDURE xxso_m_populatepfxitems;

    PROCEDURE xxso_m_pop_out_negotiated;

    PROCEDURE xxso_m_pop_out_pab;

    PROCEDURE xxso_m_print_counts;

    PROCEDURE xxso_m_check_post_errors;

    PROCEDURE xxso_m_populateebsitems;

    PROCEDURE xxso_r_reconciliation_report;

    PROCEDURE xxso_m_pop_out_transferprices;

    PROCEDURE xxso_r_recon_build;

    PROCEDURE xxso_r_recon_build_uat;

    PROCEDURE xxso_r_populateebsquotes_uat;

  FUNCTION xxso_r_compare (
        val1 in varchar2,
        val2 in varchar2        
    )
    return varchar2;

END xxso;

/
