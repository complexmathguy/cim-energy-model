import React, { Component } from 'react'
import GovHydroWEHService from '../services/GovHydroWEHService'

class ViewGovHydroWEHComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydroWEH: {}
        }
    }

    componentDidMount(){
        GovHydroWEHService.getGovHydroWEHById(this.state.id).then( res => {
            this.setState({govHydroWEH: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydroWEH Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> db:&emsp; </label>
                            <div> { this.state.govHydroWEH.db }</div>
                        </div>
                        <div className = "row">
                            <label> dicn:&emsp; </label>
                            <div> { this.state.govHydroWEH.dicn }</div>
                        </div>
                        <div className = "row">
                            <label> dpv:&emsp; </label>
                            <div> { this.state.govHydroWEH.dpv }</div>
                        </div>
                        <div className = "row">
                            <label> dturb:&emsp; </label>
                            <div> { this.state.govHydroWEH.dturb }</div>
                        </div>
                        <div className = "row">
                            <label> feedbackSignal:&emsp; </label>
                            <div> { this.state.govHydroWEH.feedbackSignal }</div>
                        </div>
                        <div className = "row">
                            <label> fl1:&emsp; </label>
                            <div> { this.state.govHydroWEH.fl1 }</div>
                        </div>
                        <div className = "row">
                            <label> fl2:&emsp; </label>
                            <div> { this.state.govHydroWEH.fl2 }</div>
                        </div>
                        <div className = "row">
                            <label> fl3:&emsp; </label>
                            <div> { this.state.govHydroWEH.fl3 }</div>
                        </div>
                        <div className = "row">
                            <label> fl4:&emsp; </label>
                            <div> { this.state.govHydroWEH.fl4 }</div>
                        </div>
                        <div className = "row">
                            <label> fl5:&emsp; </label>
                            <div> { this.state.govHydroWEH.fl5 }</div>
                        </div>
                        <div className = "row">
                            <label> fp1:&emsp; </label>
                            <div> { this.state.govHydroWEH.fp1 }</div>
                        </div>
                        <div className = "row">
                            <label> fp10:&emsp; </label>
                            <div> { this.state.govHydroWEH.fp10 }</div>
                        </div>
                        <div className = "row">
                            <label> fp2:&emsp; </label>
                            <div> { this.state.govHydroWEH.fp2 }</div>
                        </div>
                        <div className = "row">
                            <label> fp3:&emsp; </label>
                            <div> { this.state.govHydroWEH.fp3 }</div>
                        </div>
                        <div className = "row">
                            <label> fp4:&emsp; </label>
                            <div> { this.state.govHydroWEH.fp4 }</div>
                        </div>
                        <div className = "row">
                            <label> fp5:&emsp; </label>
                            <div> { this.state.govHydroWEH.fp5 }</div>
                        </div>
                        <div className = "row">
                            <label> fp6:&emsp; </label>
                            <div> { this.state.govHydroWEH.fp6 }</div>
                        </div>
                        <div className = "row">
                            <label> fp7:&emsp; </label>
                            <div> { this.state.govHydroWEH.fp7 }</div>
                        </div>
                        <div className = "row">
                            <label> fp8:&emsp; </label>
                            <div> { this.state.govHydroWEH.fp8 }</div>
                        </div>
                        <div className = "row">
                            <label> fp9:&emsp; </label>
                            <div> { this.state.govHydroWEH.fp9 }</div>
                        </div>
                        <div className = "row">
                            <label> gmax:&emsp; </label>
                            <div> { this.state.govHydroWEH.gmax }</div>
                        </div>
                        <div className = "row">
                            <label> gmin:&emsp; </label>
                            <div> { this.state.govHydroWEH.gmin }</div>
                        </div>
                        <div className = "row">
                            <label> gtmxcl:&emsp; </label>
                            <div> { this.state.govHydroWEH.gtmxcl }</div>
                        </div>
                        <div className = "row">
                            <label> gtmxop:&emsp; </label>
                            <div> { this.state.govHydroWEH.gtmxop }</div>
                        </div>
                        <div className = "row">
                            <label> gv1:&emsp; </label>
                            <div> { this.state.govHydroWEH.gv1 }</div>
                        </div>
                        <div className = "row">
                            <label> gv2:&emsp; </label>
                            <div> { this.state.govHydroWEH.gv2 }</div>
                        </div>
                        <div className = "row">
                            <label> gv3:&emsp; </label>
                            <div> { this.state.govHydroWEH.gv3 }</div>
                        </div>
                        <div className = "row">
                            <label> gv4:&emsp; </label>
                            <div> { this.state.govHydroWEH.gv4 }</div>
                        </div>
                        <div className = "row">
                            <label> gv5:&emsp; </label>
                            <div> { this.state.govHydroWEH.gv5 }</div>
                        </div>
                        <div className = "row">
                            <label> kd:&emsp; </label>
                            <div> { this.state.govHydroWEH.kd }</div>
                        </div>
                        <div className = "row">
                            <label> ki:&emsp; </label>
                            <div> { this.state.govHydroWEH.ki }</div>
                        </div>
                        <div className = "row">
                            <label> kp:&emsp; </label>
                            <div> { this.state.govHydroWEH.kp }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govHydroWEH.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> pmss1:&emsp; </label>
                            <div> { this.state.govHydroWEH.pmss1 }</div>
                        </div>
                        <div className = "row">
                            <label> pmss10:&emsp; </label>
                            <div> { this.state.govHydroWEH.pmss10 }</div>
                        </div>
                        <div className = "row">
                            <label> pmss2:&emsp; </label>
                            <div> { this.state.govHydroWEH.pmss2 }</div>
                        </div>
                        <div className = "row">
                            <label> pmss3:&emsp; </label>
                            <div> { this.state.govHydroWEH.pmss3 }</div>
                        </div>
                        <div className = "row">
                            <label> pmss4:&emsp; </label>
                            <div> { this.state.govHydroWEH.pmss4 }</div>
                        </div>
                        <div className = "row">
                            <label> pmss5:&emsp; </label>
                            <div> { this.state.govHydroWEH.pmss5 }</div>
                        </div>
                        <div className = "row">
                            <label> pmss6:&emsp; </label>
                            <div> { this.state.govHydroWEH.pmss6 }</div>
                        </div>
                        <div className = "row">
                            <label> pmss7:&emsp; </label>
                            <div> { this.state.govHydroWEH.pmss7 }</div>
                        </div>
                        <div className = "row">
                            <label> pmss8:&emsp; </label>
                            <div> { this.state.govHydroWEH.pmss8 }</div>
                        </div>
                        <div className = "row">
                            <label> pmss9:&emsp; </label>
                            <div> { this.state.govHydroWEH.pmss9 }</div>
                        </div>
                        <div className = "row">
                            <label> rpg:&emsp; </label>
                            <div> { this.state.govHydroWEH.rpg }</div>
                        </div>
                        <div className = "row">
                            <label> rpp:&emsp; </label>
                            <div> { this.state.govHydroWEH.rpp }</div>
                        </div>
                        <div className = "row">
                            <label> td:&emsp; </label>
                            <div> { this.state.govHydroWEH.td }</div>
                        </div>
                        <div className = "row">
                            <label> tdv:&emsp; </label>
                            <div> { this.state.govHydroWEH.tdv }</div>
                        </div>
                        <div className = "row">
                            <label> tg:&emsp; </label>
                            <div> { this.state.govHydroWEH.tg }</div>
                        </div>
                        <div className = "row">
                            <label> tp:&emsp; </label>
                            <div> { this.state.govHydroWEH.tp }</div>
                        </div>
                        <div className = "row">
                            <label> tpe:&emsp; </label>
                            <div> { this.state.govHydroWEH.tpe }</div>
                        </div>
                        <div className = "row">
                            <label> tw:&emsp; </label>
                            <div> { this.state.govHydroWEH.tw }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydroWEHComponent
