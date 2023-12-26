import React, { Component } from 'react'
import NuclearGeneratingUnitService from '../services/NuclearGeneratingUnitService';

class UpdateNuclearGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateNuclearGeneratingUnit = this.updateNuclearGeneratingUnit.bind(this);

    }

    componentDidMount(){
        NuclearGeneratingUnitService.getNuclearGeneratingUnitById(this.state.id).then( (res) =>{
            let nuclearGeneratingUnit = res.data;
            this.setState({
            });
        });
    }

    updateNuclearGeneratingUnit = (e) => {
        e.preventDefault();
        let nuclearGeneratingUnit = {
            nuclearGeneratingUnitId: this.state.id,
        };
        console.log('nuclearGeneratingUnit => ' + JSON.stringify(nuclearGeneratingUnit));
        console.log('id => ' + JSON.stringify(this.state.id));
        NuclearGeneratingUnitService.updateNuclearGeneratingUnit(nuclearGeneratingUnit).then( res => {
            this.props.history.push('/nuclearGeneratingUnits');
        });
    }


    cancel(){
        this.props.history.push('/nuclearGeneratingUnits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update NuclearGeneratingUnit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateNuclearGeneratingUnit}>Save</button>
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

export default UpdateNuclearGeneratingUnitComponent
