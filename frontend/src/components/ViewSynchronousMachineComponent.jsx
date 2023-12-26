import React, { Component } from 'react'
import SynchronousMachineService from '../services/SynchronousMachineService'

class ViewSynchronousMachineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            synchronousMachine: {}
        }
    }

    componentDidMount(){
        SynchronousMachineService.getSynchronousMachineById(this.state.id).then( res => {
            this.setState({synchronousMachine: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SynchronousMachine Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> earthing:&emsp; </label>
                            <div> { this.state.synchronousMachine.earthing }</div>
                        </div>
                        <div className = "row">
                            <label> earthingStarPointR:&emsp; </label>
                            <div> { this.state.synchronousMachine.earthingStarPointR }</div>
                        </div>
                        <div className = "row">
                            <label> earthingStarPointX:&emsp; </label>
                            <div> { this.state.synchronousMachine.earthingStarPointX }</div>
                        </div>
                        <div className = "row">
                            <label> ikk:&emsp; </label>
                            <div> { this.state.synchronousMachine.ikk }</div>
                        </div>
                        <div className = "row">
                            <label> maxQ:&emsp; </label>
                            <div> { this.state.synchronousMachine.maxQ }</div>
                        </div>
                        <div className = "row">
                            <label> minQ:&emsp; </label>
                            <div> { this.state.synchronousMachine.minQ }</div>
                        </div>
                        <div className = "row">
                            <label> mu:&emsp; </label>
                            <div> { this.state.synchronousMachine.mu }</div>
                        </div>
                        <div className = "row">
                            <label> qPercent:&emsp; </label>
                            <div> { this.state.synchronousMachine.qPercent }</div>
                        </div>
                        <div className = "row">
                            <label> r:&emsp; </label>
                            <div> { this.state.synchronousMachine.r }</div>
                        </div>
                        <div className = "row">
                            <label> r0:&emsp; </label>
                            <div> { this.state.synchronousMachine.r0 }</div>
                        </div>
                        <div className = "row">
                            <label> r2:&emsp; </label>
                            <div> { this.state.synchronousMachine.r2 }</div>
                        </div>
                        <div className = "row">
                            <label> satDirectSubtransX:&emsp; </label>
                            <div> { this.state.synchronousMachine.satDirectSubtransX }</div>
                        </div>
                        <div className = "row">
                            <label> satDirectSyncX:&emsp; </label>
                            <div> { this.state.synchronousMachine.satDirectSyncX }</div>
                        </div>
                        <div className = "row">
                            <label> satDirectTransX:&emsp; </label>
                            <div> { this.state.synchronousMachine.satDirectTransX }</div>
                        </div>
                        <div className = "row">
                            <label> shortCircuitRotorType:&emsp; </label>
                            <div> { this.state.synchronousMachine.shortCircuitRotorType }</div>
                        </div>
                        <div className = "row">
                            <label> type:&emsp; </label>
                            <div> { this.state.synchronousMachine.type }</div>
                        </div>
                        <div className = "row">
                            <label> voltageRegulationRange:&emsp; </label>
                            <div> { this.state.synchronousMachine.voltageRegulationRange }</div>
                        </div>
                        <div className = "row">
                            <label> x0:&emsp; </label>
                            <div> { this.state.synchronousMachine.x0 }</div>
                        </div>
                        <div className = "row">
                            <label> x2:&emsp; </label>
                            <div> { this.state.synchronousMachine.x2 }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSynchronousMachineComponent
