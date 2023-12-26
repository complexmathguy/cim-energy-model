import React, { Component } from 'react'
import DiscreteService from '../services/DiscreteService';

class CreateDiscreteComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            DiscreteService.getDiscreteById(this.state.id).then( (res) =>{
                let discrete = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDiscrete = (e) => {
        e.preventDefault();
        let discrete = {
                discreteId: this.state.id,
            };
        console.log('discrete => ' + JSON.stringify(discrete));

        // step 5
        if(this.state.id === '_add'){
            discrete.discreteId=''
            DiscreteService.createDiscrete(discrete).then(res =>{
                this.props.history.push('/discretes');
            });
        }else{
            DiscreteService.updateDiscrete(discrete).then( res => {
                this.props.history.push('/discretes');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/discretes');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Discrete</h3>
        }else{
            return <h3 className="text-center">Update Discrete</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDiscrete}>Save</button>
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

export default CreateDiscreteComponent
