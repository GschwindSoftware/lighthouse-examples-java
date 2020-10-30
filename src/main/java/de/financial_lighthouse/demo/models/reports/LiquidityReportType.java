package de.financial_lighthouse.demo.models.reports;

/**
 * Arten von Liquiditätsauswertungen.
 */
public enum LiquidityReportType {
    /**
     * Report vom Typ "AgricultureIncome".
     */
    AgricultureIncome,
    /**
     * Report vom Typ "AssetFormation".
     */
    AssetFormation,
    /**
     * Report vom Typ "BusinessIncome".
     */
    BusinessIncome,
    /**
     * Report vom Typ "CapitalIncome".
     */
    CapitalIncome,
    /**
     * Report vom Typ "CompanyPension".
     */
    CompanyPension,
    /**
     * Report vom Typ "CumulatedLiquidity".
     */
    CumulatedLiquidity,
    /**
     * Report vom Typ "EmployedIncome".
     */
    EmployedIncome,
    /**
     * Report vom Typ "Expenses".
     */
    Expenses,
    /**
     * Report vom Typ "HealthAssessmentReduced".
     */
    HealthAssessmentReduced,
    /**
     * Report vom Typ "HealthAssessment".
     */
    HealthAssessment,
    /**
     * Report vom Typ "HealthIncomeReduced".
     */
    HealthIncomeReduced,
    /**
     * Report vom Typ "HealthInsuranceGeneral".
     */
    HealthInsuranceGeneral,
    /**
     * Report vom Typ "HealthInsuranceReduced".
     */
    HealthInsuranceReduced,
    /**
     * Report vom Typ "HealthInsuranceRefund".
     */
    HealthInsuranceRefund,
    /**
     * Report vom Typ "HealthInsurance".
     */
    HealthInsurance,
    /**
     * Report vom Typ "HealthSocialSecurityContributions".
     */
    HealthSocialSecurityContributions,
    /**
     * Report vom Typ "Income".
     */
    Income,
    /**
     * Report vom Typ "InsuranceExpenses".
     */
    InsuranceExpenses,
    /**
     * Report vom Typ "InterestExpenses".
     */
    InterestExpenses,
    /**
     * Report vom Typ "LettingAndLeasingIncome".
     */
    LettingAndLeasingIncome,
    /**
     * Report vom Typ "LettingAndLeasingItem".
     */
    LettingAndLeasingItem,
    /**
     * Report vom Typ "Liquidity".
     */
    Liquidity,
    /**
     * Report vom Typ "LivingExpenses".
     */
    LivingExpenses,
    /**
     * Report vom Typ "NursingCareAssessment".
     */
    NursingCareAssessment,
    /**
     * Report vom Typ "NursingCareInsurance".
     */
    NursingCareInsurance,
    /**
     * Report vom Typ "NursingCareRefund".
     */
    NursingCareRefund,
    /**
     * Report vom Typ "NursingCareSocialSecurityIncome".
     */
    NursingCareSocialSecurityIncome,
    /**
     * Report vom Typ "OtherExpenses".
     */
    OtherExpenses,
    /**
     * Report vom Typ "OtherIncome".
     */
    OtherIncome,
    /**
     * Report vom Typ "PensionAssessment".
     */
    PensionAssessment,
    /**
     * Report vom Typ "PensionInsuranceRefund".
     */
    PensionInsuranceRefund,
    /**
     * Report vom Typ "PensionInsurance".
     */
    PensionInsurance,
    /**
     * Report vom Typ "PensionPlanExpenses".
     */
    PensionPlanExpenses,
    /**
     * Report vom Typ "PensionSocialSecurityIncome".
     */
    PensionSocialSecurityIncome,
    /**
     * Report vom Typ "PersonalInsurances".
     */
    PersonalInsurances,
    /**
     * Report vom Typ "PrivateHealthInsurances".
     */
    PrivateHealthInsurances,
    /**
     * Report vom Typ "PrivatePension".
     */
    PrivatePension,
    /**
     * Report vom Typ "Repayments".
     */
    Repayments,
    /**
     * Report vom Typ "SelfEmployedIncome".
     */
    SelfEmployedIncome,
    /**
     * Report vom Typ "SocialContributionsItem".
     */
    SocialContributionsItem,
    /**
     * Report vom Typ "SocialContributions".
     */
    SocialContributions,
    /**
     * Report vom Typ "SocialSecurityCompanyPension".
     */
    SocialSecurityCompanyPension,
    /**
     * Report vom Typ "SocialSecurityContributions".
     */
    SocialSecurityContributions,
    /**
     * Report vom Typ "SocialSecurityPensionCommitment".
     */
    SocialSecurityPensionCommitment,
    /**
     * Report vom Typ "SocialSecurityProvidentFund".
     */
    SocialSecurityProvidentFund,
    /**
     * Report vom Typ "StatutoryPension".
     */
    StatutoryPension,
    /**
     * Report vom Typ "TradeTaxAssessment".
     */
    TradeTaxAssessment,
    /**
     * Report vom Typ "TradeTaxItem".
     */
    TradeTaxItem,
    /**
     * Report vom Typ "UnemploymentAssessment".
     */
    UnemploymentAssessment,
    /**
     * Report vom Typ "UnemploymentInsuranceRefund".
     */
    UnemploymentInsuranceRefund,
    /**
     * Report vom Typ "UnemploymentInsurance".
     */
    UnemploymentInsurance,
    /**
     * Report vom Typ "UnemploymentSocialSecurityIncome".
     */
    UnemploymentSocialSecurityIncome,
    /**
     * Report vom Typ "WidowsAssetsReduction".
     */
    WidowsAssetsReduction,
    /**
     * Report vom Typ "WidowsCivilServantReduction".
     */
    WidowsCivilServantReduction,
    /**
     * Report vom Typ "WidowsCompanyPensionReduction".
     */
    WidowsCompanyPensionReduction,
    /**
     * Report vom Typ "WidowsEarnedReduction".
     */
    WidowsEarnedReduction,
    /**
     * Report vom Typ "WidowsMinijobRVReduction".
     */
    WidowsMinijobRVReduction,
    /**
     * Report vom Typ "WidowsMinijobReduction".
     */
    WidowsMinijobReduction,
    /**
     * Report vom Typ "WidowsPensionAllowance".
     */
    WidowsPensionAllowance,
    /**
     * Report vom Typ "WidowsPensionChildAllowance".
     */
    WidowsPensionChildAllowance,
    /**
     * Report vom Typ "WidowsPensionItem".
     */
    WidowsPensionItem,
    /**
     * Report vom Typ "WidowsPensionReduction".
     */
    WidowsPensionReduction,
    /**
     * Report vom Typ "WidowsPrivatePensionReduction".
     */
    WidowsPrivatePensionReduction,
    /**
     * Report vom Typ "WidowsProfessionalPensionReduction".
     */
    WidowsProfessionalPensionReduction,
    /**
     * Report vom Typ "WidowsStatuoryPensionReduction".
     */
    WidowsStatuoryPensionReduction,
    /**
     * Report vom Typ "WidowsWageCompensationReduction".
     */
    WidowsWageCompensationReduction,
    /**
     * Report vom Typ "WidowsWageReduction".
     */
    WidowsWageReduction
}
