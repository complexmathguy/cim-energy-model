import React, { Component } from 'react'
import InductancePerLengthService from '../services/InductancePerLengthService'

class ViewInductancePerLengthComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            inductancePerLength: {}
        }
    }

    componentDidMount(){
        InductancePerLengthService.getInductancePerLengthById(this.state.id).then( res => {
            this.setState({inductancePerLength: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View InductancePerLength Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> denominatorMultiplier:&emsp; </label>
                            <div> { this.state.inductancePerLength.denominatorMultiplier }</div>
                        </div>
                        <div className = "row">
                            <label> denominatorUnit:&emsp; </label>
                            <div> { this.state.inductancePerLength.denominatorUnit }</div>
                        </div>
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.inductancePerLength.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.inductancePerLength.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.inductancePerLength.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewInductancePerLengthComponent
