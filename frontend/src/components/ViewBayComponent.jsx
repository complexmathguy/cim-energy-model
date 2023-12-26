import React, { Component } from 'react'
import BayService from '../services/BayService'

class ViewBayComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            bay: {}
        }
    }

    componentDidMount(){
        BayService.getBayById(this.state.id).then( res => {
            this.setState({bay: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Bay Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewBayComponent
