Feature: Test

  Scenario Outline : Verify Launches in Report Portal
    Given I am logged into Report Portal
    And I have a project with test results
    When I navigate to the 'Launchers' section
    Then I should see a list of available test result "<status>"

    Examples:
    status
    total
    passed
    failed
    skipped
    product bug
    auto bug
    system issue
    to investigate

  Scenario Outline : Verify Launches in Report Portal
    Given I am logged into Report Portal
    And I have a project with test results
    When I navigate to the 'Launchers' section
    Then I should see a  build with '<number>'

    Examples:
    number
    build:3.2.14.55.28
    build:3.2.14.55.23
    build:3.2.14.55.19
    build:3.2.14.55.13
    build:3.2.14.55.7

  Scenario Outline : Verify Launches in Report Portal
    Given I am logged into Report Portal
    And I have a project with test results
    When I navigate to the 'Launchers' section
    And I navigate to 'Launcher' page
    Then I should see a  defect type '<defect>'

    Examples:
    defect
    PB
    AB
    SI
    ND
    TI