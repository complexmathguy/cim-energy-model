import React, { Component } from 'react'
import AnalogLimitService from '../services/AnalogLimitService'

class ViewAnalogLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            analogLimit: {}
        }
    }

    componentDidMount(){
        AnalogLimitService.getAnalogLimitById(this.state.id).then( res => {
            this.setState({analogLimit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View AnalogLimit Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.analogLimit.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAnalogLimitComponent
