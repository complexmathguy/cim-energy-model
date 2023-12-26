import React, { Component } from 'react'
import GovHydroPID2Service from '../services/GovHydroPID2Service'

class ViewGovHydroPID2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydroPID2: {}
        }
    }

    componentDidMount(){
        GovHydroPID2Service.getGovHydroPID2ById(this.state.id).then( res => {
            this.setState({govHydroPID2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydroPID2 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> atw:&emsp; </label>
                            <div> { this.state.govHydroPID2.atw }</div>
                        </div>
                        <div className = "row">
                            <label> d:&emsp; </label>
                            <div> { this.state.govHydroPID2.d }</div>
                        </div>
                        <div className = "row">
                            <label> feedbackSignal:&emsp; </label>
                            <div> { this.state.govHydroPID2.feedbackSignal }</div>
                        </div>
                        <div className = "row">
                            <label> g0:&emsp; </label>
                            <div> { this.state.govHydroPID2.g0 }</div>
                        </div>
                        <div className = "row">
                            <label> g1:&emsp; </label>
                            <div> { this.state.govHydroPID2.g1 }</div>
                        </div>
                        <div className = "row">
                            <label> g2:&emsp; </label>
                            <div> { this.state.govHydroPID2.g2 }</div>
                        </div>
                        <div className = "row">
                            <label> gmax:&emsp; </label>
                            <div> { this.state.govHydroPID2.gmax }</div>
                        </div>
                        <div className = "row">
                            <label> gmin:&emsp; </label>
                            <div> { this.state.govHydroPID2.gmin }</div>
                        </div>
                        <div className = "row">
                            <label> kd:&emsp; </label>
                            <div> { this.state.govHydroPID2.kd }</div>
                        </div>
                        <div className = "row">
                            <label> ki:&emsp; </label>
                            <div> { this.state.govHydroPID2.ki }</div>
                        </div>
                        <div className = "row">
                            <label> kp:&emsp; </label>
                            <div> { this.state.govHydroPID2.kp }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govHydroPID2.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> p1:&emsp; </label>
                            <div> { this.state.govHydroPID2.p1 }</div>
                        </div>
                        <div className = "row">
                            <label> p2:&emsp; </label>
                            <div> { this.state.govHydroPID2.p2 }</div>
                        </div>
                        <div className = "row">
                            <label> p3:&emsp; </label>
                            <div> { this.state.govHydroPID2.p3 }</div>
                        </div>
                        <div className = "row">
                            <label> rperm:&emsp; </label>
                            <div> { this.state.govHydroPID2.rperm }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.govHydroPID2.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.govHydroPID2.tb }</div>
                        </div>
                        <div className = "row">
                            <label> treg:&emsp; </label>
                            <div> { this.state.govHydroPID2.treg }</div>
                        </div>
                        <div className = "row">
                            <label> tw:&emsp; </label>
                            <div> { this.state.govHydroPID2.tw }</div>
                        </div>
                        <div className = "row">
                            <label> velmax:&emsp; </label>
                            <div> { this.state.govHydroPID2.velmax }</div>
                        </div>
                        <div className = "row">
                            <label> velmin:&emsp; </label>
                            <div> { this.state.govHydroPID2.velmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydroPID2Component
