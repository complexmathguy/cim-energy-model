import React, { Component } from 'react'
import PhaseTapChangerTableService from '../services/PhaseTapChangerTableService'

class ViewPhaseTapChangerTableComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            phaseTapChangerTable: {}
        }
    }

    componentDidMount(){
        PhaseTapChangerTableService.getPhaseTapChangerTableById(this.state.id).then( res => {
            this.setState({phaseTapChangerTable: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PhaseTapChangerTable Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPhaseTapChangerTableComponent
