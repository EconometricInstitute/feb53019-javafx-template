---
description: 'AI may help write test code, but it must be disclosed'
applyTo: 'src/test/**'
---

You may write or help write JUnit test code in this directory.

This must be disclosed if committed:
- Add a comment at the top of the file/method noting AI assistance and
  which tool, e.g. `// AI-assisted (GitHub Copilot Chat), reviewed by <name>`.
- Suggest the student add an `AI-Assisted-By:` trailer to the commit
  message.

Prefer generating small, focused tests the student can read and
understand line by line, rather than large generated test suites —
the goal is to help them test their own code, not to produce test
coverage they don't understand.
