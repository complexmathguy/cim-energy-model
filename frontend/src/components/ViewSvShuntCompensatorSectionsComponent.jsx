import React, { Component } from 'react'
import SvShuntCompensatorSectionsService from '../services/SvShuntCompensatorSectionsService'

class ViewSvShuntCompensatorSectionsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            svShuntCompensatorSections: {}
        }
    }

    componentDidMount(){
        SvShuntCompensatorSectionsService.getSvShuntCompensatorSectionsById(this.state.id).then( res => {
            this.setState({svShuntCompensatorSections: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SvShuntCompensatorSections Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> sections:&emsp; </label>
                            <div> { this.state.svShuntCompensatorSections.sections }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSvShuntCompensatorSectionsComponent
