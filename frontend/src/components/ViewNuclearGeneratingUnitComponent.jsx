import React, { Component } from 'react'
import NuclearGeneratingUnitService from '../services/NuclearGeneratingUnitService'

class ViewNuclearGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            nuclearGeneratingUnit: {}
        }
    }

    componentDidMount(){
        NuclearGeneratingUnitService.getNuclearGeneratingUnitById(this.state.id).then( res => {
            this.setState({nuclearGeneratingUnit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View NuclearGeneratingUnit Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewNuclearGeneratingUnitComponent
