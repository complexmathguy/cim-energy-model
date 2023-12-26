import React, { Component } from 'react'
import GovHydroPeltonService from '../services/GovHydroPeltonService'

class ViewGovHydroPeltonComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydroPelton: {}
        }
    }

    componentDidMount(){
        GovHydroPeltonService.getGovHydroPeltonById(this.state.id).then( res => {
            this.setState({govHydroPelton: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydroPelton Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> av0:&emsp; </label>
                            <div> { this.state.govHydroPelton.av0 }</div>
                        </div>
                        <div className = "row">
                            <label> av1:&emsp; </label>
                            <div> { this.state.govHydroPelton.av1 }</div>
                        </div>
                        <div className = "row">
                            <label> bp:&emsp; </label>
                            <div> { this.state.govHydroPelton.bp }</div>
                        </div>
                        <div className = "row">
                            <label> db1:&emsp; </label>
                            <div> { this.state.govHydroPelton.db1 }</div>
                        </div>
                        <div className = "row">
                            <label> db2:&emsp; </label>
                            <div> { this.state.govHydroPelton.db2 }</div>
                        </div>
                        <div className = "row">
                            <label> h1:&emsp; </label>
                            <div> { this.state.govHydroPelton.h1 }</div>
                        </div>
                        <div className = "row">
                            <label> h2:&emsp; </label>
                            <div> { this.state.govHydroPelton.h2 }</div>
                        </div>
                        <div className = "row">
                            <label> hn:&emsp; </label>
                            <div> { this.state.govHydroPelton.hn }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.govHydroPelton.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kg:&emsp; </label>
                            <div> { this.state.govHydroPelton.kg }</div>
                        </div>
                        <div className = "row">
                            <label> qc0:&emsp; </label>
                            <div> { this.state.govHydroPelton.qc0 }</div>
                        </div>
                        <div className = "row">
                            <label> qn:&emsp; </label>
                            <div> { this.state.govHydroPelton.qn }</div>
                        </div>
                        <div className = "row">
                            <label> simplifiedPelton:&emsp; </label>
                            <div> { this.state.govHydroPelton.simplifiedPelton }</div>
                        </div>
                        <div className = "row">
                            <label> staticCompensating:&emsp; </label>
                            <div> { this.state.govHydroPelton.staticCompensating }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.govHydroPelton.ta }</div>
                        </div>
                        <div className = "row">
                            <label> ts:&emsp; </label>
                            <div> { this.state.govHydroPelton.ts }</div>
                        </div>
                        <div className = "row">
                            <label> tv:&emsp; </label>
                            <div> { this.state.govHydroPelton.tv }</div>
                        </div>
                        <div className = "row">
                            <label> twnc:&emsp; </label>
                            <div> { this.state.govHydroPelton.twnc }</div>
                        </div>
                        <div className = "row">
                            <label> twng:&emsp; </label>
                            <div> { this.state.govHydroPelton.twng }</div>
                        </div>
                        <div className = "row">
                            <label> tx:&emsp; </label>
                            <div> { this.state.govHydroPelton.tx }</div>
                        </div>
                        <div className = "row">
                            <label> va:&emsp; </label>
                            <div> { this.state.govHydroPelton.va }</div>
                        </div>
                        <div className = "row">
                            <label> valvmax:&emsp; </label>
                            <div> { this.state.govHydroPelton.valvmax }</div>
                        </div>
                        <div className = "row">
                            <label> valvmin:&emsp; </label>
                            <div> { this.state.govHydroPelton.valvmin }</div>
                        </div>
                        <div className = "row">
                            <label> vav:&emsp; </label>
                            <div> { this.state.govHydroPelton.vav }</div>
                        </div>
                        <div className = "row">
                            <label> vc:&emsp; </label>
                            <div> { this.state.govHydroPelton.vc }</div>
                        </div>
                        <div className = "row">
                            <label> vcv:&emsp; </label>
                            <div> { this.state.govHydroPelton.vcv }</div>
                        </div>
                        <div className = "row">
                            <label> waterTunnelSurgeChamberSimulation:&emsp; </label>
                            <div> { this.state.govHydroPelton.waterTunnelSurgeChamberSimulation }</div>
                        </div>
                        <div className = "row">
                            <label> zsfc:&emsp; </label>
                            <div> { this.state.govHydroPelton.zsfc }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydroPeltonComponent
