import React, { Component } from 'react'
import WindTurbineType4aIECService from '../services/WindTurbineType4aIECService'

class ViewWindTurbineType4aIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windTurbineType4aIEC: {}
        }
    }

    componentDidMount(){
        WindTurbineType4aIECService.getWindTurbineType4aIECById(this.state.id).then( res => {
            this.setState({windTurbineType4aIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindTurbineType4aIEC Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindTurbineType4aIECComponent
