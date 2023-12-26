import React, { Component } from 'react'
import ReactiveCapabilityCurveService from '../services/ReactiveCapabilityCurveService'

class ViewReactiveCapabilityCurveComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            reactiveCapabilityCurve: {}
        }
    }

    componentDidMount(){
        ReactiveCapabilityCurveService.getReactiveCapabilityCurveById(this.state.id).then( res => {
            this.setState({reactiveCapabilityCurve: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ReactiveCapabilityCurve Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewReactiveCapabilityCurveComponent
