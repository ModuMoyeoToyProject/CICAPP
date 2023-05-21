package pojo.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class CicApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		String [] beanNames = context.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanNames));
//        SDO = service domain object.
//        CDO = create domain object -> 생성되는 객체값이 있는 것만 등록.

//      self Test Case. 시작..
//		UserVO userVo = new UserVO("User", "Test User");
//      여기서 만드는 CDO는 생성되는 녀석에 대한 파라미터만 들어있다. id는 entity에서 만들어준다. 이녀석만 넘긴다. name과 intro만.


		//스프링 컨테이너가 생성한 빈을 들고와야 한다.
		//생성된 CDO의 서비스 빈을 그대로 들고오고 class를 가져온다.
//		UserSer clubService = context.getBean("clubService", ClubService.class);

		//서비스에서 레지스터 클럽을 하게 되면 만들어놓은 객체가 들어간다.
		//빈에 따라서 생성된 CDO의 id를 가져온다.
//		String clubId = clubService.registerClub(clubCdo);
//        System.out.println("ID :"  + clubId);
//        System.out.println(clubCdo.getName());
//        System.out.println(clubCdo.getIntro());

//		TravelClub foundedClub = clubService.findClubById(clubId);

//        System.out.println("ID : " + foundedClub.getId());
//        System.out.println("Name : " + foundedClub.getName());
//        System.out.println("intro : " + foundedClub.getIntro());
//        System.out.println("time : " + new Date(foundedClub.getFoundationTime()));

		SpringApplication.run(CicApplication.class, args);
		System.out.println("Server is running. Welcome to CafeInCode.");

	}

}
