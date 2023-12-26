import React, { Component } from 'react'
import PowerTransformerEndService from '../services/PowerTransformerEndService'

class ViewPowerTransformerEndComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            powerTransformerEnd: {}
        }
    }

    componentDidMount(){
        PowerTransformerEndService.getPowerTransformerEndById(this.state.id).then( res => {
            this.setState({powerTransformerEnd: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PowerTransformerEnd Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> b:&emsp; </label>
                            <div> { this.state.powerTransformerEnd.b }</div>
                        </div>
                        <div className = "row">
                            <label> b0:&emsp; </label>
                            <div> { this.state.powerTransformerEnd.b0 }</div>
                        </div>
                        <div className = "row">
                            <label> connectionKind:&emsp; </label>
                            <div> { this.state.powerTransformerEnd.connectionKind }</div>
                        </div>
                        <div className = "row">
                            <label> g:&emsp; </label>
                            <div> { this.state.powerTransformerEnd.g }</div>
                        </div>
                        <div className = "row">
                            <label> g0:&emsp; </label>
                            <div> { this.state.powerTransformerEnd.g0 }</div>
                        </div>
                        <div className = "row">
                            <label> phaseAngleClock:&emsp; </label>
                            <div> { this.state.powerTransformerEnd.phaseAngleClock }</div>
                        </div>
                        <div className = "row">
                            <label> r:&emsp; </label>
                            <div> { this.state.powerTransformerEnd.r }</div>
                        </div>
                        <div className = "row">
                            <label> r0:&emsp; </label>
                            <div> { this.state.powerTransformerEnd.r0 }</div>
                        </div>
                        <div className = "row">
                            <label> ratedS:&emsp; </label>
                            <div> { this.state.powerTransformerEnd.ratedS }</div>
                        </div>
                        <div className = "row">
                            <label> ratedU:&emsp; </label>
                            <div> { this.state.powerTransformerEnd.ratedU }</div>
                        </div>
                        <div className = "row">
                            <label> x:&emsp; </label>
                            <div> { this.state.powerTransformerEnd.x }</div>
                        </div>
                        <div className = "row">
                            <label> x0:&emsp; </label>
                            <div> { this.state.powerTransformerEnd.x0 }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPowerTransformerEndComponent
