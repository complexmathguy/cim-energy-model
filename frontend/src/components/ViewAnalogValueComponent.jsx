import React, { Component } from 'react'
import AnalogValueService from '../services/AnalogValueService'

class ViewAnalogValueComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            analogValue: {}
        }
    }

    componentDidMount(){
        AnalogValueService.getAnalogValueById(this.state.id).then( res => {
            this.setState({analogValue: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View AnalogValue Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.analogValue.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAnalogValueComponent
