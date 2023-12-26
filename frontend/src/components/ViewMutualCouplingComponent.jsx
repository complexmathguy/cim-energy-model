import React, { Component } from 'react'
import MutualCouplingService from '../services/MutualCouplingService'

class ViewMutualCouplingComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            mutualCoupling: {}
        }
    }

    componentDidMount(){
        MutualCouplingService.getMutualCouplingById(this.state.id).then( res => {
            this.setState({mutualCoupling: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View MutualCoupling Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> b0ch:&emsp; </label>
                            <div> { this.state.mutualCoupling.b0ch }</div>
                        </div>
                        <div className = "row">
                            <label> distance11:&emsp; </label>
                            <div> { this.state.mutualCoupling.distance11 }</div>
                        </div>
                        <div className = "row">
                            <label> distance12:&emsp; </label>
                            <div> { this.state.mutualCoupling.distance12 }</div>
                        </div>
                        <div className = "row">
                            <label> distance21:&emsp; </label>
                            <div> { this.state.mutualCoupling.distance21 }</div>
                        </div>
                        <div className = "row">
                            <label> distance22:&emsp; </label>
                            <div> { this.state.mutualCoupling.distance22 }</div>
                        </div>
                        <div className = "row">
                            <label> g0ch:&emsp; </label>
                            <div> { this.state.mutualCoupling.g0ch }</div>
                        </div>
                        <div className = "row">
                            <label> r0:&emsp; </label>
                            <div> { this.state.mutualCoupling.r0 }</div>
                        </div>
                        <div className = "row">
                            <label> x0:&emsp; </label>
                            <div> { this.state.mutualCoupling.x0 }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewMutualCouplingComponent
