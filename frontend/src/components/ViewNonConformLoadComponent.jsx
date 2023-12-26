import React, { Component } from 'react'
import NonConformLoadService from '../services/NonConformLoadService'

class ViewNonConformLoadComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            nonConformLoad: {}
        }
    }

    componentDidMount(){
        NonConformLoadService.getNonConformLoadById(this.state.id).then( res => {
            this.setState({nonConformLoad: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View NonConformLoad Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewNonConformLoadComponent
