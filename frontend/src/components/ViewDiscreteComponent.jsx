import React, { Component } from 'react'
import DiscreteService from '../services/DiscreteService'

class ViewDiscreteComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            discrete: {}
        }
    }

    componentDidMount(){
        DiscreteService.getDiscreteById(this.state.id).then( res => {
            this.setState({discrete: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Discrete Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDiscreteComponent
