import React, { Component } from 'react'
import FloatProxyService from '../services/FloatProxyService'

class ViewFloatProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            floatProxy: {}
        }
    }

    componentDidMount(){
        FloatProxyService.getFloatProxyById(this.state.id).then( res => {
            this.setState({floatProxy: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View FloatProxy Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewFloatProxyComponent
