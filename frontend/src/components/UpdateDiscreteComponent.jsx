import React, { Component } from 'react'
import DiscreteService from '../services/DiscreteService';

class UpdateDiscreteComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDiscrete = this.updateDiscrete.bind(this);

    }

    componentDidMount(){
        DiscreteService.getDiscreteById(this.state.id).then( (res) =>{
            let discrete = res.data;
            this.setState({
            });
        });
    }

    updateDiscrete = (e) => {
        e.preventDefault();
        let discrete = {
            discreteId: this.state.id,
        };
        console.log('discrete => ' + JSON.stringify(discrete));
        console.log('id => ' + JSON.stringify(this.state.id));
        DiscreteService.updateDiscrete(discrete).then( res => {
            this.props.history.push('/discretes');
        });
    }


    cancel(){
        this.props.history.push('/discretes');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Discrete</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDiscrete}>Save</button>
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

export default UpdateDiscreteComponent
