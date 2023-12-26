import React, { Component } from 'react'
import ConformLoadService from '../services/ConformLoadService'

class ViewConformLoadComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            conformLoad: {}
        }
    }

    componentDidMount(){
        ConformLoadService.getConformLoadById(this.state.id).then( res => {
            this.setState({conformLoad: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ConformLoad Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewConformLoadComponent
