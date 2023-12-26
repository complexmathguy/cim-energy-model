import React, { Component } from 'react'
import StringProxyService from '../services/StringProxyService'

class ViewStringProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            stringProxy: {}
        }
    }

    componentDidMount(){
        StringProxyService.getStringProxyById(this.state.id).then( res => {
            this.setState({stringProxy: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View StringProxy Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewStringProxyComponent
