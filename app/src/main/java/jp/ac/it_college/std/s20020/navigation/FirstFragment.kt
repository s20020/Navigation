package jp.ac.it_college.std.s20020.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import jp.ac.it_college.std.s20020.navigation.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
   private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // NavHostの取得
        val navHostFragment =
            requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        // NavController取得
        val navController = navHostFragment.navController
        //go2のアクション
        val action2 = FirstFragmentDirections.actionFirstFragmentToSecondFragment()

        //go3のアクション
        val action3 = FirstFragmentDirections.actionFirstFragmentToThreeFragment()
        binding.go2.setOnClickListener{
            navController.navigate(action2)
        }
        binding.go3.setOnClickListener{
            navController.navigate(action3)
        }


    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}