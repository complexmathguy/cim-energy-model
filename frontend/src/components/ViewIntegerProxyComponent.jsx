import React, { Component } from 'react'
import IntegerProxyService from '../services/IntegerProxyService'

class ViewIntegerProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            integerProxy: {}
        }
    }

    componentDidMount(){
        IntegerProxyService.getIntegerProxyById(this.state.id).then( res => {
            this.setState({integerProxy: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View IntegerProxy Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewIntegerProxyComponent
