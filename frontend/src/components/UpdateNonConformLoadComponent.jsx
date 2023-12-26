import React, { Component } from 'react'
import NonConformLoadService from '../services/NonConformLoadService';

class UpdateNonConformLoadComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateNonConformLoad = this.updateNonConformLoad.bind(this);

    }

    componentDidMount(){
        NonConformLoadService.getNonConformLoadById(this.state.id).then( (res) =>{
            let nonConformLoad = res.data;
            this.setState({
            });
        });
    }

    updateNonConformLoad = (e) => {
        e.preventDefault();
        let nonConformLoad = {
            nonConformLoadId: this.state.id,
        };
        console.log('nonConformLoad => ' + JSON.stringify(nonConformLoad));
        console.log('id => ' + JSON.stringify(this.state.id));
        NonConformLoadService.updateNonConformLoad(nonConformLoad).then( res => {
            this.props.history.push('/nonConformLoads');
        });
    }


    cancel(){
        this.props.history.push('/nonConformLoads');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update NonConformLoad</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateNonConformLoad}>Save</button>
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

export default UpdateNonConformLoadComponent
