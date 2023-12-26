import React, { Component } from 'react'
import RegulatingCondEqService from '../services/RegulatingCondEqService'

class ViewRegulatingCondEqComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            regulatingCondEq: {}
        }
    }

    componentDidMount(){
        RegulatingCondEqService.getRegulatingCondEqById(this.state.id).then( res => {
            this.setState({regulatingCondEq: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View RegulatingCondEq Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewRegulatingCondEqComponent
