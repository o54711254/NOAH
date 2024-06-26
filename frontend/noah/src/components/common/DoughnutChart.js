import { useEffect, useState, React } from "react";
import styles from "./DoughnutChart.module.css";

export default function DoughnutChart({ percent = 0 }) {
  const [t, setT] = useState(0);
  const donutStyle = {
    background: `conic-gradient(#2f80ED 0% ${t}%, #66ACFF ${t}% 100%)`,
  };

  useEffect(() => {
    const donutAnimation = setInterval(() => {
      if (t >= percent) {
        clearInterval(donutAnimation);
      } else {
        setT(t + 1);
      }
    }, 10);

    return () => clearInterval(donutAnimation); // 컴포넌트 언마운트 시 인터벌 클리어
  }, [t, percent]);

  return (
    <>
      <div className={styles.doughnut} style={donutStyle}>
        <div className={styles.percent}>{t}%</div> {/* 중앙에 표시될 퍼센트 */}
      </div>
    </>
  );
}
