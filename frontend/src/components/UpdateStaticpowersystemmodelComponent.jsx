import React, { Component } from 'react'
import StaticpowersystemmodelService from '../services/StaticpowersystemmodelService';

class UpdateStaticpowersystemmodelComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateStaticpowersystemmodel = this.updateStaticpowersystemmodel.bind(this);

    }

    componentDidMount(){
        StaticpowersystemmodelService.getStaticpowersystemmodelById(this.state.id).then( (res) =>{
            let staticpowersystemmodel = res.data;
            this.setState({
            });
        });
    }

    updateStaticpowersystemmodel = (e) => {
        e.preventDefault();
        let staticpowersystemmodel = {
            staticpowersystemmodelId: this.state.id,
        };
        console.log('staticpowersystemmodel => ' + JSON.stringify(staticpowersystemmodel));
        console.log('id => ' + JSON.stringify(this.state.id));
        StaticpowersystemmodelService.updateStaticpowersystemmodel(staticpowersystemmodel).then( res => {
            this.props.history.push('/staticpowersystemmodels');
        });
    }


    cancel(){
        this.props.history.push('/staticpowersystemmodels');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Staticpowersystemmodel</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateStaticpowersystemmodel}>Save</button>
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

export default UpdateStaticpowersystemmodelComponent
