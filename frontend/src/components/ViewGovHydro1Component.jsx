import React, { Component } from 'react'
import GovHydro1Service from '../services/GovHydro1Service'

class ViewGovHydro1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydro1: {}
        }
    }

    componentDidMount(){
        GovHydro1Service.getGovHydro1ById(this.state.id).then( res => {
            this.setState({govHydro1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydro1 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> at:&emsp; </label>
                            <div> { this.state.govHydro1.at }</div>
                        </div>
                        <div className = "row">
                            <label> dturb:&emsp; </label>
                            <div> { this.state.govHydro1.dturb }</div>
                        </div>
                        <div className = "row">
                            <label> gmax:&emsp; </label>
                            <div> { this.state.govHydro1.gmax }</div>
                        </div>
                        <div className = "row">
                            <label> gmin:&emsp; </label>
                            <div> { this.state.govHydro1.gmin }</div>
                        </div>
                        <div className = "row">
                            <label> hdam:&emsp; </label>
                            <div> { this.state.govHydro1.hdam }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govHydro1.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> qnl:&emsp; </label>
                            <div> { this.state.govHydro1.qnl }</div>
                        </div>
                        <div className = "row">
                            <label> rperm:&emsp; </label>
                            <div> { this.state.govHydro1.rperm }</div>
                        </div>
                        <div className = "row">
                            <label> rtemp:&emsp; </label>
                            <div> { this.state.govHydro1.rtemp }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.govHydro1.tf }</div>
                        </div>
                        <div className = "row">
                            <label> tg:&emsp; </label>
                            <div> { this.state.govHydro1.tg }</div>
                        </div>
                        <div className = "row">
                            <label> tr:&emsp; </label>
                            <div> { this.state.govHydro1.tr }</div>
                        </div>
                        <div className = "row">
                            <label> tw:&emsp; </label>
                            <div> { this.state.govHydro1.tw }</div>
                        </div>
                        <div className = "row">
                            <label> velm:&emsp; </label>
                            <div> { this.state.govHydro1.velm }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydro1Component
