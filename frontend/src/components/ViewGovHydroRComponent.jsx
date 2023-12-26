import React, { Component } from 'react'
import GovHydroRService from '../services/GovHydroRService'

class ViewGovHydroRComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydroR: {}
        }
    }

    componentDidMount(){
        GovHydroRService.getGovHydroRById(this.state.id).then( res => {
            this.setState({govHydroR: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydroR Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> at:&emsp; </label>
                            <div> { this.state.govHydroR.at }</div>
                        </div>
                        <div className = "row">
                            <label> db1:&emsp; </label>
                            <div> { this.state.govHydroR.db1 }</div>
                        </div>
                        <div className = "row">
                            <label> db2:&emsp; </label>
                            <div> { this.state.govHydroR.db2 }</div>
                        </div>
                        <div className = "row">
                            <label> dturb:&emsp; </label>
                            <div> { this.state.govHydroR.dturb }</div>
                        </div>
                        <div className = "row">
                            <label> eps:&emsp; </label>
                            <div> { this.state.govHydroR.eps }</div>
                        </div>
                        <div className = "row">
                            <label> gmax:&emsp; </label>
                            <div> { this.state.govHydroR.gmax }</div>
                        </div>
                        <div className = "row">
                            <label> gmin:&emsp; </label>
                            <div> { this.state.govHydroR.gmin }</div>
                        </div>
                        <div className = "row">
                            <label> gv1:&emsp; </label>
                            <div> { this.state.govHydroR.gv1 }</div>
                        </div>
                        <div className = "row">
                            <label> gv2:&emsp; </label>
                            <div> { this.state.govHydroR.gv2 }</div>
                        </div>
                        <div className = "row">
                            <label> gv3:&emsp; </label>
                            <div> { this.state.govHydroR.gv3 }</div>
                        </div>
                        <div className = "row">
                            <label> gv4:&emsp; </label>
                            <div> { this.state.govHydroR.gv4 }</div>
                        </div>
                        <div className = "row">
                            <label> gv5:&emsp; </label>
                            <div> { this.state.govHydroR.gv5 }</div>
                        </div>
                        <div className = "row">
                            <label> gv6:&emsp; </label>
                            <div> { this.state.govHydroR.gv6 }</div>
                        </div>
                        <div className = "row">
                            <label> h0:&emsp; </label>
                            <div> { this.state.govHydroR.h0 }</div>
                        </div>
                        <div className = "row">
                            <label> inputSignal:&emsp; </label>
                            <div> { this.state.govHydroR.inputSignal }</div>
                        </div>
                        <div className = "row">
                            <label> kg:&emsp; </label>
                            <div> { this.state.govHydroR.kg }</div>
                        </div>
                        <div className = "row">
                            <label> ki:&emsp; </label>
                            <div> { this.state.govHydroR.ki }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govHydroR.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> pgv1:&emsp; </label>
                            <div> { this.state.govHydroR.pgv1 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv2:&emsp; </label>
                            <div> { this.state.govHydroR.pgv2 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv3:&emsp; </label>
                            <div> { this.state.govHydroR.pgv3 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv4:&emsp; </label>
                            <div> { this.state.govHydroR.pgv4 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv5:&emsp; </label>
                            <div> { this.state.govHydroR.pgv5 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv6:&emsp; </label>
                            <div> { this.state.govHydroR.pgv6 }</div>
                        </div>
                        <div className = "row">
                            <label> pmax:&emsp; </label>
                            <div> { this.state.govHydroR.pmax }</div>
                        </div>
                        <div className = "row">
                            <label> pmin:&emsp; </label>
                            <div> { this.state.govHydroR.pmin }</div>
                        </div>
                        <div className = "row">
                            <label> qnl:&emsp; </label>
                            <div> { this.state.govHydroR.qnl }</div>
                        </div>
                        <div className = "row">
                            <label> r:&emsp; </label>
                            <div> { this.state.govHydroR.r }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.govHydroR.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.govHydroR.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.govHydroR.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.govHydroR.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> t5:&emsp; </label>
                            <div> { this.state.govHydroR.t5 }</div>
                        </div>
                        <div className = "row">
                            <label> t6:&emsp; </label>
                            <div> { this.state.govHydroR.t6 }</div>
                        </div>
                        <div className = "row">
                            <label> t7:&emsp; </label>
                            <div> { this.state.govHydroR.t7 }</div>
                        </div>
                        <div className = "row">
                            <label> t8:&emsp; </label>
                            <div> { this.state.govHydroR.t8 }</div>
                        </div>
                        <div className = "row">
                            <label> td:&emsp; </label>
                            <div> { this.state.govHydroR.td }</div>
                        </div>
                        <div className = "row">
                            <label> tp:&emsp; </label>
                            <div> { this.state.govHydroR.tp }</div>
                        </div>
                        <div className = "row">
                            <label> tt:&emsp; </label>
                            <div> { this.state.govHydroR.tt }</div>
                        </div>
                        <div className = "row">
                            <label> tw:&emsp; </label>
                            <div> { this.state.govHydroR.tw }</div>
                        </div>
                        <div className = "row">
                            <label> velcl:&emsp; </label>
                            <div> { this.state.govHydroR.velcl }</div>
                        </div>
                        <div className = "row">
                            <label> velop:&emsp; </label>
                            <div> { this.state.govHydroR.velop }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydroRComponent
