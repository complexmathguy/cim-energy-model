import React, { Component } from 'react'
import DecimalProxyService from '../services/DecimalProxyService'

class ViewDecimalProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            decimalProxy: {}
        }
    }

    componentDidMount(){
        DecimalProxyService.getDecimalProxyById(this.state.id).then( res => {
            this.setState({decimalProxy: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DecimalProxy Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDecimalProxyComponent
