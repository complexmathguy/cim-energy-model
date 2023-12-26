import React, { Component } from 'react'
import VsCapabilityCurveService from '../services/VsCapabilityCurveService'

class ViewVsCapabilityCurveComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            vsCapabilityCurve: {}
        }
    }

    componentDidMount(){
        VsCapabilityCurveService.getVsCapabilityCurveById(this.state.id).then( res => {
            this.setState({vsCapabilityCurve: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View VsCapabilityCurve Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewVsCapabilityCurveComponent
