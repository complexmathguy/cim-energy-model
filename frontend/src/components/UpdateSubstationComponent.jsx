import React, { Component } from 'react'
import SubstationService from '../services/SubstationService';

class UpdateSubstationComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateSubstation = this.updateSubstation.bind(this);

    }

    componentDidMount(){
        SubstationService.getSubstationById(this.state.id).then( (res) =>{
            let substation = res.data;
            this.setState({
            });
        });
    }

    updateSubstation = (e) => {
        e.preventDefault();
        let substation = {
            substationId: this.state.id,
        };
        console.log('substation => ' + JSON.stringify(substation));
        console.log('id => ' + JSON.stringify(this.state.id));
        SubstationService.updateSubstation(substation).then( res => {
            this.props.history.push('/substations');
        });
    }


    cancel(){
        this.props.history.push('/substations');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Substation</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSubstation}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateSubstationComponent
