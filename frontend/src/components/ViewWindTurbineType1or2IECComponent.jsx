import React, { Component } from 'react'
import WindTurbineType1or2IECService from '../services/WindTurbineType1or2IECService'

class ViewWindTurbineType1or2IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windTurbineType1or2IEC: {}
        }
    }

    componentDidMount(){
        WindTurbineType1or2IECService.getWindTurbineType1or2IECById(this.state.id).then( res => {
            this.setState({windTurbineType1or2IEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindTurbineType1or2IEC Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindTurbineType1or2IECComponent
