# copy paste code from eclipse to Git directory
cp /d/eclipse-workspace-developer/Algorithms/src/* src/ -r
echo Done to copy paste job!
git status
git add .
echo Done to stage changes!
git commit -m "Updated Algorithms project"
echo Done to commit code!
git push
echo Done to push code!