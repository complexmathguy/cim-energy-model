import React, { Component } from 'react'
import GovHydroIEEE2Service from '../services/GovHydroIEEE2Service'

class ViewGovHydroIEEE2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydroIEEE2: {}
        }
    }

    componentDidMount(){
        GovHydroIEEE2Service.getGovHydroIEEE2ById(this.state.id).then( res => {
            this.setState({govHydroIEEE2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydroIEEE2 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> aturb:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.aturb }</div>
                        </div>
                        <div className = "row">
                            <label> bturb:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.bturb }</div>
                        </div>
                        <div className = "row">
                            <label> gv1:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.gv1 }</div>
                        </div>
                        <div className = "row">
                            <label> gv2:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.gv2 }</div>
                        </div>
                        <div className = "row">
                            <label> gv3:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.gv3 }</div>
                        </div>
                        <div className = "row">
                            <label> gv4:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.gv4 }</div>
                        </div>
                        <div className = "row">
                            <label> gv5:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.gv5 }</div>
                        </div>
                        <div className = "row">
                            <label> gv6:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.gv6 }</div>
                        </div>
                        <div className = "row">
                            <label> kturb:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.kturb }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> pgv1:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.pgv1 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv2:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.pgv2 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv3:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.pgv3 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv4:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.pgv4 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv5:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.pgv5 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv6:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.pgv6 }</div>
                        </div>
                        <div className = "row">
                            <label> pmax:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.pmax }</div>
                        </div>
                        <div className = "row">
                            <label> pmin:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.pmin }</div>
                        </div>
                        <div className = "row">
                            <label> rperm:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.rperm }</div>
                        </div>
                        <div className = "row">
                            <label> rtemp:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.rtemp }</div>
                        </div>
                        <div className = "row">
                            <label> tg:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.tg }</div>
                        </div>
                        <div className = "row">
                            <label> tp:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.tp }</div>
                        </div>
                        <div className = "row">
                            <label> tr:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.tr }</div>
                        </div>
                        <div className = "row">
                            <label> tw:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.tw }</div>
                        </div>
                        <div className = "row">
                            <label> uc:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.uc }</div>
                        </div>
                        <div className = "row">
                            <label> uo:&emsp; </label>
                            <div> { this.state.govHydroIEEE2.uo }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydroIEEE2Component
