import React, { Component } from 'react'
import HydroPumpService from '../services/HydroPumpService';

class UpdateHydroPumpComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateHydroPump = this.updateHydroPump.bind(this);

    }

    componentDidMount(){
        HydroPumpService.getHydroPumpById(this.state.id).then( (res) =>{
            let hydroPump = res.data;
            this.setState({
            });
        });
    }

    updateHydroPump = (e) => {
        e.preventDefault();
        let hydroPump = {
            hydroPumpId: this.state.id,
        };
        console.log('hydroPump => ' + JSON.stringify(hydroPump));
        console.log('id => ' + JSON.stringify(this.state.id));
        HydroPumpService.updateHydroPump(hydroPump).then( res => {
            this.props.history.push('/hydroPumps');
        });
    }


    cancel(){
        this.props.history.push('/hydroPumps');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update HydroPump</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateHydroPump}>Save</button>
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

export default UpdateHydroPumpComponent
