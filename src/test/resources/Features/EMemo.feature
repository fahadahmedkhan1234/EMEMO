Feature: Create A Memo

  Scenario: Open url and select form
    When open url "https://uatsharepoint.bankislami.com.pk/_login/default.aspx?ReturnUrl=%2fsites%2fememo%2f_layouts%2f15%2fAuthenticate.aspx%3fSource%3d%252Fsites%252Fememo%252FSitePages%252Fdashboard%252Easpx&Source=%2Fsites%2Fememo%2FSitePages%2Fdashboard%2Easpx"
    And click on dropdown and select form
    Then enter login details
    Then click on sign in button
    Then open New EMeme and fill the form and click on submit button
    And click on My EMemo


