# Git workflow for this project

You don't need to know all of git — just this one loop, repeated. Do
everything below through IntelliJ's Git menu / Pull Requests tool
window; you shouldn't need the terminal.

## The loop (repeat this for every change)

1. **Update main**: `Git > Pull` while on the `main` branch, so you
   start from the latest version.
2. **Create a branch**: `Git > New Branch`, give it a short name
   describing what you're doing (e.g. `minimax-ai`, `fix-board-bug`).
3. **Work and commit often**: small, frequent commits are easier to
   understand later than one giant commit. `Git > Commit`.
4. **Push your branch**: `Git > Push`.
5. **Open a Pull Request**: use the `Pull Requests` tool window in
   IntelliJ, or the "Compare & pull request" button that appears on
   GitHub.com after you push. Fill in the AI-use disclosure checklist.
6. **Merge on GitHub.com**: once any required checks pass, click
   "Merge pull request" on the PR page.
7. **Switch back to main and pull**: `Git > Pull` again, so your local
   `main` has the change you just merged. Delete the old branch.

That's it — for 90% of changes, you'll never need anything beyond this.

## What's the ✅/❌ check that appears on my PR?

If this repo includes `.github/workflows/build.yml`, every PR
automatically runs `mvn test` on GitHub's servers and reports the
result directly on the PR page — you don't need to do anything to
trigger it.

- **Green check**: your code compiles and all tests pass.
- **Red X**: something's broken. Click "Details" next to the check to
  see the log and find the error — it's the same output you'd get
  running `mvn test` locally.

To fix a red check: fix the problem locally, commit, and push to the
**same branch**. You don't need to open a new PR — the check
automatically re-runs on your new commit.

This check is separate from who can merge (see "Protecting main"
below) — whether it's required to pass before merging, or just shown
as information, depends on how this repo's rules were configured.

## Working solo? This still applies, and it's not awkward

If you're working alone, you still open a PR for your own changes —
but you will never be asked to "approve" your own work. This repo's
branch protection requires 0 approvals, so the Merge button is simply
available once any automated checks pass. There's no self-review step.

The PR is still worth doing solo because it: gives you a spot to fill
in the AI-use disclosure checklist, triggers the automated test check
before anything lands on `main` (so `main` never silently breaks), and
leaves a short written record of what each chunk of work was for.

## Protecting `main`

The whole point of the loop above is that `main` always stays in a
working state — nobody pushes straight to it, changes only land there
through a reviewed, tested Pull Request.

**If you see an error trying to push straight to `main`:** that's
expected and working as intended. Follow the loop above instead of
trying to force it.

**If pushing straight to `main` currently just... works, with no
error:** that means protection hasn't been turned on for your specific
repo yet, and you should enable it yourself before you start working —
this can happen if you created your own private repo from the template
rather than getting one that was set up for you. It's a 2-minute
one-time setup:

1. On GitHub.com, go to your repo's **Settings > Rules > Rulesets**
   (or **Settings > Branches** on older UI).
2. Create a new ruleset targeting the `main` branch.
3. Enable **"Require a pull request before merging"**, and leave
   required approvals at **0** (this is intentional — see "Working
   solo" above; it also keeps things simple for groups).
4. If this repo has the `.github/workflows/build.yml` test workflow,
   you can optionally add it as a required status check too, once it
   has run at least once.
5. Save. From then on, `main` behaves as described above.

Either way — whether protection was already set up for you or you set
it up yourself — the day-to-day loop above doesn't change.

## If GitHub says your branch has a merge conflict

This means someone else changed the same lines you did. Don't panic:

1. On your branch, `Git > Update Project` (or pull `main` into your
   branch) to bring in the latest `main`.
2. IntelliJ will show conflicting sections. Talk to your groupmate
   about which version should win (or combine both).
3. Resolve each conflict, commit, and push again.

Conflicts are much rarer if branches are short-lived (merge within a
day or two) and group members work on different files/features at the
same time.
