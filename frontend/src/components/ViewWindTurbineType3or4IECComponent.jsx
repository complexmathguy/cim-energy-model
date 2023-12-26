import React, { Component } from 'react'
import WindTurbineType3or4IECService from '../services/WindTurbineType3or4IECService'

class ViewWindTurbineType3or4IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windTurbineType3or4IEC: {}
        }
    }

    componentDidMount(){
        WindTurbineType3or4IECService.getWindTurbineType3or4IECById(this.state.id).then( res => {
            this.setState({windTurbineType3or4IEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindTurbineType3or4IEC Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindTurbineType3or4IECComponent
