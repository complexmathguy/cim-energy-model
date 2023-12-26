import React, { Component } from 'react'
import BooleanProxyService from '../services/BooleanProxyService'

class ViewBooleanProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            booleanProxy: {}
        }
    }

    componentDidMount(){
        BooleanProxyService.getBooleanProxyById(this.state.id).then( res => {
            this.setState({booleanProxy: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View BooleanProxy Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewBooleanProxyComponent
