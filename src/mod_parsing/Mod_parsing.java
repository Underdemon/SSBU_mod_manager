/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod_parsing;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.regex.*;
import static java.nio.file.FileVisitResult.*;
/**
 *
 * @author Admin
 */
public class Mod_parsing
{

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException
    {
        //Files.walk(dir).filter(Files::isDirectory).forEach(System.out::println);
        // https://stackoverflow.com/questions/31020269/what-is-the-use-of-system-outprintln-in-java-8
        //Files.walk(dir).filter(p -> p.getFileName().toString().matches("c0[0-9]")).forEach(System.out::println);
        /*
        Files.walk(dir).filter(p -> p.getFileName().toString().matches("fighter")).map(p ->
        {
            return p.getParent().equals("fighter")
                    || p.getParent().equals("ui")
                    || p.getParent().equals("stream;")
                    || p.getParent().equals("stage")
                    || p.getParent().equals("effect")
                    || p.getParent().equals("boss")
                    || p.getParent().equals("param")
                    || p.getParent().equals("sound");
        });
        */
        
        //https://www.baeldung.com/regular-expressions-java
        
        /*
        Pattern pttrn = Pattern.compile("(fighter)|(ui)|(stream;)|(stage)|(effect)|(boss)|(param)|(sound)");    //defines regex pattern to test (& compiles it?)
        Files.walk(dir).forEach
        (
                file ->
                {
                    Matcher mtchr = pttrn.matcher(file.getFileName().toString());   //matches string to pattern defined above
                    while(mtchr.find()) //check all occurences
                    {
                        if(!mtchr.group().equals(null))
                            System.out.println("\n" + file.getParent().getFileName().toString() + "\n" + "|" + "\n|___" + mtchr.group());
                    }
                }
        );
        */
        Path dir = Paths.get("R:\\switch sutff\\smash ult modding\\mods");
        PrintFiles pf = new PrintFiles();
        Files.walkFileTree(dir, pf);
    }

    public static class PrintFiles extends SimpleFileVisitor<Path>
    {
        final Pattern type = Pattern.compile("(fighter)|(ui)|(stream;)|(stage)|(effect)|(boss)|(param)|(sound)");    //defines regex pattern to test (& compiles it?)
        final Pattern fight = Pattern.compile("fighter");
        final Pattern slot = Pattern.compile("c0[0-7]");
        final Pattern ui = Pattern.compile("chara_[0-7]");
        // Print information about
        // each type of file.
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attr)
        {
            Matcher fighter = fight.matcher(file.getFileName().toString());
            if(fighter.find())
                System.out.println("\t" + file.normalize().toString());

            return CONTINUE;
        }

        // Print each directory visited.
        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc)
        {
            //System.out.format("Directory: %s%n", dir);
            return CONTINUE;
        }

        // If there is some error accessing
        // the file, let the user know.
        // If you don't override this method
        // and an error occurs, an IOException
        // is thrown.
        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc)
        {
            System.err.println(exc);
            return CONTINUE;
        }
    }
}



// LEARNING:
//===========
/*
https://docs.oracle.com/javase/tutorial/essential/io/walk.html


nio api
    file.walk
        multiwalking?!? <https://stackoverflow.com/questions/60714501/how-to-walk-multiple-directories-with-multiple-file-extensions-in-java>
        secret technique multithread multiwalking?!??!??
    directorystream
    globbing vs regex (pattern matching)
        https://docs.oracle.com/javase/tutorial/essential/io/dirs.html#listall && https://docs.oracle.com/javase/tutorial/essential/io/fileOps.html#glob

    https://howtodoinjava.com/java8/java-8-list-all-files-example/#12-directorystream-to-loop-through-files
    https://jenkov.com/tutorials/java-nio/path.html#:~:text=A%20Java%20Path%20instance%20represents,or%20directory%20it%20points%20to.
    https://stackoverflow.com/a/33567427
    https://stackoverflow.com/questions/794381/how-to-find-files-that-match-a-wildcard-string-in-java
    https://howtodoinjava.com/java8/java-8-list-all-files-example/#12-directorystream-to-loop-through-files

*/

//      File[] directories = new File(inp).listFiles(File::isDirectory;
/*
        makes an array of all directory names
        must import import java.io.File; for use of File class
*/


/*
        IGNORE BELOW JUST FIND IF FOLDER NAME HAS fighter, ui, stream;, stage, effect, boss, item, param, sound, snapshot
*/

/*

1.Mario- {mario}

2.Donkey Kong- {donkey}

3.Link- {link}

4.Samus- {samus}

4E.Dark Samus- {samusd}

5.Yoshi- {yoshi}

6.Kirby- {kirby}

7.Fox- {fox}

8.Pikachu- {pikachu}

9.Luigi- {luigi}

10.Ness- {ness}

11.Captain Falcon- {captain}

12.Jigglypuff- {purin}

13.Peach- {peach}

13E.Daisy- {daisy}

14.Bowser- {koopa}

14B.Giga Bowser- {koopag}

15.Ice Climbers- {nana} & {popo}

16.Sheik- {sheik}

17.Zelda- {zelda}

18.Dr.Mario- {mariod}

19.Pichu- {pichu}

20.Falco- {falco}

21.Marth- {marth}

21E.Lucina- {lucina}

22.Young Link- {younglink}

23.Ganondorf- {ganon}

24.Mewtwo- {mewtwo}

25.Roy- {roy}

25E.Chrom- {chrom}

26.Mr.Game & Watch- {gamewatch}

27.Meta Knight- {metaknight}

28.Pit- {pit}

28E.Dark Pit- {pitb}

29.Zero Suit Samus- {szerosuit}

30.Wario- {wario}

31.Snake- {snake}

32.Ike- {ike}

33.Pokémon Trainer- {ptrainer}

33P.Squitle- {pzenigame}

34P.Ivysaur- {pfushigisou}

35P.Charizard- {plizardon}

36.Diddy Kong- {diddy}

37.Lucas- {lucas}

38.Sonic- {sonic}

39.King Dedede- {dedede}

40.Olimar- {pikmin}

41.Lucario- {lucario}

42.R.O.B.- {robot}

43.Toon Link- {toonlink}

44.Wolf- {wolf}

45.Villager- {murabito}

46.Mega Man- {rockman}

47.Wii Fit Trainer- {wiifit}

48.RosaLina & Luma- {rosetta}

49.Little Mac- {littlemac}

50.Greninja- {gekkouga}

51.Mii Brawler- {miifighter}

52.Mii Swordfighter- {miiswordsman}

53.Mii Gunner- {miigunner}

54.Palutena- {palutena}

55.Pac-man- {pacman}

56.Robin- {reflet}

57.Shulk- {shulk}

58.Bowser JR.- {koopajr}

59.Duck Hunt- {duckhunt}

60.Ryu- {ryu}

60E.Ken- {ken}

61.Cloud- {cloud}

62.Corrin- {kamui}

63.Bayonetta- {bayonetta}

64.Inkling- {inkling}

65.Ridley- {ridley}

66.Simon- {simon}

66E.Richter- {richter}

67.King K. Rool- {krool}

68.Isabelle- {shizue}

69.Incineroar- {gaogaen}

70.Piranha Plant- {packun}

71.Joker- {jack}

72.Hero- {brave}

73.Banjo & Kazooie- {buddy}

74.Terry- {dolly}

75.Byleth- {master}

76.Min Min- {tantan}

77.Steve- {pickel}

78.Sephiroth- {edge}

79.Pyra- {eflame}

 79-80. Rex- {element }   {Both share together} Rex is not a fighter

80.Mythra- {elight}

81.Kazuya- {demon}

82.Sora- {trail}
*/

/*
possible naming conventions (fname = fightername, sname = stagename):
finalsmash/fname
camera/fighter/fname/c00-c07
effect/fighter/fname (mainly this one and less of the one below)
effect/fighter/fname/model
effect/stage/sname
fighter/fname/(...)/c00-c07
stage/sname
*/

//https://raw.githubusercontent.com/ultimate-research/archive-hashes/master/Hashes

