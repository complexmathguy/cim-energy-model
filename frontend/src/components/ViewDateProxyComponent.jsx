import React, { Component } from 'react'
import DateProxyService from '../services/DateProxyService'

class ViewDateProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dateProxy: {}
        }
    }

    componentDidMount(){
        DateProxyService.getDateProxyById(this.state.id).then( res => {
            this.setState({dateProxy: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DateProxy Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDateProxyComponent
