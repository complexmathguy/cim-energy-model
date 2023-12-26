import React, { Component } from 'react'
import WindGeneratingUnitService from '../services/WindGeneratingUnitService'

class ViewWindGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windGeneratingUnit: {}
        }
    }

    componentDidMount(){
        WindGeneratingUnitService.getWindGeneratingUnitById(this.state.id).then( res => {
            this.setState({windGeneratingUnit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindGeneratingUnit Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> windGenUnitType:&emsp; </label>
                            <div> { this.state.windGeneratingUnit.windGenUnitType }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindGeneratingUnitComponent
