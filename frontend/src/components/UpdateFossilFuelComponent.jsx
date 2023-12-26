import React, { Component } from 'react'
import FossilFuelService from '../services/FossilFuelService';

class UpdateFossilFuelComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                fossilFuelType: ''
        }
        this.updateFossilFuel = this.updateFossilFuel.bind(this);

        this.changefossilFuelTypeHandler = this.changefossilFuelTypeHandler.bind(this);
    }

    componentDidMount(){
        FossilFuelService.getFossilFuelById(this.state.id).then( (res) =>{
            let fossilFuel = res.data;
            this.setState({
                fossilFuelType: fossilFuel.fossilFuelType
            });
        });
    }

    updateFossilFuel = (e) => {
        e.preventDefault();
        let fossilFuel = {
            fossilFuelId: this.state.id,
            fossilFuelType: this.state.fossilFuelType
        };
        console.log('fossilFuel => ' + JSON.stringify(fossilFuel));
        console.log('id => ' + JSON.stringify(this.state.id));
        FossilFuelService.updateFossilFuel(fossilFuel).then( res => {
            this.props.history.push('/fossilFuels');
        });
    }

    changefossilFuelTypeHandler= (event) => {
        this.setState({fossilFuelType: event.target.value});
    }

    cancel(){
        this.props.history.push('/fossilFuels');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update FossilFuel</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> fossilFuelType: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateFossilFuel}>Save</button>
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

export default UpdateFossilFuelComponent
