import React, { Component } from 'react'
import AnalogService from '../services/AnalogService'

class ViewAnalogComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            analog: {}
        }
    }

    componentDidMount(){
        AnalogService.getAnalogById(this.state.id).then( res => {
            this.setState({analog: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Analog Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> positiveFlowIn:&emsp; </label>
                            <div> { this.state.analog.positiveFlowIn }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAnalogComponent
