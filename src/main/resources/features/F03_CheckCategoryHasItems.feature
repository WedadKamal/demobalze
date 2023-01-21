@smoke


Feature: F03_CheckCategoryHasItems | user could Check Category Has Items

  Scenario: F03_CheckCategoryHasItems | user could Check Category Has Items

    When get categories text
    Then Assert categories have Items
